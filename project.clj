(defproject clj-cljs-experiment "0.1.0-SNAPSHOT"
  :description "FIXME: write description"

  :url "http://example.com/FIXME"

  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure        "1.5.1"]
                 [com.stuartsierra/component "0.2.1"]
                 [compojure                  "1.1.5"]
                 [ring/ring-core             "1.1.8"]
                 [http-kit                   "2.0.0"]]

  :profiles {:dev {:source-paths ["dev"]
                   :dependencies [[org.clojure/tools.namespace "0.2.3"]]}})
