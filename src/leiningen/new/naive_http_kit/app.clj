(ns {{name}}.app
  (:use [compojure.core :only [defroutes GET POST]]
        [compojure.handler :only [site]])
  (:require [compojure.route :as route]
            [ring.middleware.reload :as reload]
            [net.cgrand.enlive-html :as html]
            [{{name}}.utils :as utils]))

(html/deftemplate index-tpl "templates/index.html" [])

(defn index [req]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    (index-tpl)})

(defroutes app
  (GET "/" [] index)
  (route/resources "/")
  (route/not-found "<p>Page not found.</p>"))

(def app (-> app
            site
            utils/wrap-logging
            reload/wrap-reload))
