(ns {{namespace}}
  (:gen-class)
  (:use [org.httpkit.server :only [run-server]]
        [{{name}}.app :only [app]]
        [taoensso.timbre :only [info]]))

(defn -main
  [& args]
  (run-server app {:port 8080})
  (info "Server started at http://localhost:8080"))
