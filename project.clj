(defproject yesql-examples "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [yesql "0.5.0-beta2"]
                 [org.clojure/java.jdbc "0.3.7"]
                 [com.h2database/h2 "1.4.187"]]
  :profiles
  {:dev
   {:dependencies
   [[pjstadig/humane-test-output "0.7.0"]]
   :injections
   [(require 'pjstadig.humane-test-output)
    (pjstadig.humane-test-output/activate!)]}})
