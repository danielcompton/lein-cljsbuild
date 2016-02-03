(defproject cljsbuild "2.0.0-SNAPSHOT"
  :description "ClojureScript Autobuilder"
  :url "http://github.com/emezeske/lein-cljsbuild"
  :license
    {:name "Eclipse Public License - v 1.0"
     :url "http://www.eclipse.org/legal/epl-v10.html"
     :distribution :repo}
  :dependencies
    [[org.clojure/clojure "1.5.1"]
     [org.clojure/clojurescript "0.0-3211"
       :exclusions [org.apache.ant/ant]]
     [fs "1.1.2"]
     [clj-stacktrace "0.2.5"]]
  :aot [cljsbuild.test]
  :release-tasks [["vcs" "assert-committed"]
                  ["change" "version" "leiningen.release/bump-version" "release"]
                  ["vcs" "commit"]
                  ["vcs" "tag"]
                  #_["deploy"]
                  ["change" "version" "leiningen.release/bump-version"]
                  ["vcs" "commit"]
                  ["vcs" "push"]]
  :deploy-repositories [["releases" :clojars]
                        ["snapshots" :clojars]]
  :vcs :git ; We specify :vcs here because our git root isn't at the same level as our project.clj
  :profiles {
    :dev {
      :dependencies [[midje "1.6.3"]]
      :plugins [[lein-midje "3.1.3"]]}})
