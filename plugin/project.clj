(defproject lein-cljsbuild "2.0.0"
  :description "ClojureScript Autobuilder Plugin"
  :url "http://github.com/emezeske/lein-cljsbuild"
  :license
    {:name "Eclipse Public License - v 1.0"
     :url "http://www.eclipse.org/legal/epl-v10.html"
     :distribution :repo}
    :dependencies [[fs "1.1.2"]]
  :profiles {
    :dev {
      :dependencies [
        [midje "1.6.3"]
        [cljsbuild "1.1.2"]]
      :plugins [[lein-midje "3.1.3"]]}}
  :release-tasks [["vcs" "assert-committed"]
                  ["change" "version" "leiningen.release/bump-version" "release"]
                  ["vcs" "commit"]
                  ["vcs" "tag"]
                  #_["deploy"]
                  ["change" "version" "leiningen.release/bump-version"]
                  ["vcs" "commit"]
                  ["vcs" "push"]]
  :vcs :git ; We specify :vcs here because our git root isn't at the same level as our project.clj
  :deploy-repositories [["releases" :clojars]
                        ["snapshots" :clojars]]
  :eval-in-leiningen true)
