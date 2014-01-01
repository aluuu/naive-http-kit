(ns leiningen.new.naive-http-kit
  (:require [leiningen.new.templates :refer [renderer year project-name
                                             ->files sanitize-ns name-to-path
                                             multi-segment]]
            [leiningen.core.main :as main]))

(defn naive-http-kit
  "An application project template."
  [name]
  (let [render (renderer "naive-http-kit")
        main-ns (multi-segment (sanitize-ns name))
        data {:raw-name name
              :name (project-name name)
              :namespace main-ns
              :nested-dirs (name-to-path main-ns)
              :year (year)}]
    (main/info "Generating a project called" name "based on the 'naive-http-kit' template.")
    (->files data
             ["project.clj" (render "project.clj" data)]
             [".gitignore" (render "gitignore" data)]
             ["src/clj/{{name}}/core.clj" (render "core.clj" data)]
             ["src/clj/{{name}}/app.clj" (render "app.clj" data)]
             ["src/clj/{{name}}/utils.clj" (render "utils.clj" data)]
             ["src/cljs/{{name}}/core.cljs" (render "core.cljs" data)]
             ["resources/templates/index.html" (render "index.html" data)]
             "resources/public")))
