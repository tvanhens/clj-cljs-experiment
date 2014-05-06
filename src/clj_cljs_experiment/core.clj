(ns clj-cljs-experiment.core
  (:require [org.httpkit.server :refer :all]
            [com.stuartsierra.component :as component]))

(defn app [req]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body    "hello HTTP!"})

(defrecord WebServer [server port]
  component/Lifecycle

  (start [component]
    (println (:port component))
    (assoc component :server (run-server #'app
                                         {:port (:port component)})))

  (stop [component]
    ((:server component))
    (assoc component :server nil)))

(defn new-web-server [{port :port}]
  (map->WebServer {:port port}))

(defn system []
  (new-web-server {:port 8080}))
