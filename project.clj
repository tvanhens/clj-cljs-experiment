(defproject clj-cljs-experiment "0.1.0-SNAPSHOT"
  :description "FIXME: write description"

  :url "http://example.com/FIXME"

  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :source-paths ["src/clj" "src/cljs"]

  :dependencies [[org.clojure/clojure        "1.5.1"]
                 [com.stuartsierra/component "0.2.1"]
                 [org.clojure/clojurescript  "0.0-2138"]
                 [compojure                  "1.1.5"]
                 [ring/ring-core             "1.1.8"]
                 [enlive                     "1.1.5"]
                 [http-kit                   "2.0.0"]]

  :profiles {:dev {:source-paths ["dev"]
                   :dependencies [[org.clojure/tools.namespace "0.2.3"]]
                   :plugins [[com.cemerick/austin "0.1.3"]
                             [lein-cljsbuild      "1.0.1"]]
                   :cljsbuild {:builds [{:source-paths ["src/cljs"]
                                         :compiler     {:output-to     "target/classes/public/app.js"
                                                        :optimizations :simple
                                                        :pretty-print  true}}]}}})
