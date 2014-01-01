(ns {{name}}.utils
  (:require [taoensso.timbre :as timbre
             :refer (log  trace  debug  info  warn  error  fatal  report
                          logf tracef debugf infof warnf errorf fatalf reportf
                          spy logged-future with-log-level)]))

(defn wrap-logging [handler]
  (fn [request]
    (let [response (handler request)]
      (debug (str (:request-method request) " " (:uri request) " " (:status response)))
      response)))
