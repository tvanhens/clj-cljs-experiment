(ns clj-cljs-experiment.core
  (:require [org.httpkit.server :refer :all]
            [cemerick.austin.repls :refer (browser-connected-repl-js)]
            [com.stuartsierra.component :as component]
            [net.cgrand.enlive-html :as enlive]
            [compojure.route :refer [resources]]
            [compojure.core :refer [GET defroutes]]
            [compojure.handler :refer [site]]
            [clojure.java.io :as io]))

(enlive/deftemplate page
  (io/resource "index.html")
  []
  [:body] (enlive/append
            (enlive/html [:script (browser-connected-repl-js)])))

(defroutes app 
  (resources "/")
  (GET "/*" req (page)))

(defrecord WebServer [port]
  component/Lifecycle
  (start [component]
    (assoc component :server (run-server (site #'app)
                                         {:port port})))
  (stop [component]
    ((:server component))
    (assoc component :server nil)))

(defn new-web-server [{port :port}]
  (map->WebServer {:port port}))

(defn system []
  (new-web-server {:port 8080}))
