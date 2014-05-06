(ns clj-cljs-experiment.core
  (:require [org.httpkit.server :refer :all]
            [com.stuartsierra.component :as component]))

(defn app [req]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body    "hello HTTP!"})

(defrecord WebServer [port]
  component/Lifecycle
  (start [component]
    (assoc component :server (run-server #'app
                                         {:port port})))
  (stop [component]
    ((:server component))
    (assoc component :server nil)))

(defn new-web-server [{port :port}]
  (map->WebServer {:port port}))

(defn system []
  (new-web-server {:port 8080}))
