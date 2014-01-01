(ns {{name}}.app
  (:use [compojure.core :only [defroutes GET POST]]
        [compojure.handler :only [site]])
  (:require [compojure.route :as route]
            [ring.middleware.reload :as reload]
            [{{name}}.utils :as utils]))

(defn index [req]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    "hello HTTP!"})

(defroutes app
  (GET "/" [] index)
  (route/resources "/")
  (route/not-found "<p>Page not found.</p>"))

(def app (-> app
            site
            utils/wrap-logging
            reload/wrap-reload))
