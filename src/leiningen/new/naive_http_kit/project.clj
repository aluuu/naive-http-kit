(defproject {{raw-name}} "0.1.0-SNAPSHOT"
  :description "FIXME: write description"

  :url "http://example.com/FIXME"

  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2030"]

                 [http-kit "2.1.13"]

                 [javax.servlet/servlet-api "2.5"]
                 [ring/ring-devel "1.2.1"]
                 [ring/ring-core "1.2.1" :exclusions [org.clojure/tools.reader]]
                 [compojure "1.1.6"]
                 [enlive "1.1.5"]

                 [com.taoensso/timbre "3.0.0-RC2"]]

  :plugins [[lein-cljsbuild "1.0.0-alpha2"]]

  :main ^:skip-aot {{namespace}}

  :source-paths ["src/clj"]

  :target-path "target/%s"

  :cljsbuild {
    :builds [{:id "{{name}}"
              :source-paths ["src/cljs"]
              :compiler {
                :output-to "resources/public/js/{{name}}.js"
                :output-dir "resources/public/js"
                :optimizations :none
                :source-map true}}]}

  :profiles {:uberjar {:aot :all}})
