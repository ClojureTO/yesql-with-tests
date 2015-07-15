(ns yesql-examples.core-test
  (:require [clojure.test :refer :all]
            [clojure.java.io :as io]
            [yesql-examples.core :refer :all]))

(defn reset-db! []
  (letfn [(delete [f]
            (when (.exists f)
              (.delete f)))]
    (delete (io/file "store.db.trace.db"))
    (delete (io/file "store.db.mv.db"))
    (create-user-table db-spec)))

(defn setup-test-db [f]
  (println "deleting users")
  (reset-db!)
  (f))

(use-fixtures :each setup-test-db)

(deftest test-add-user
  (testing "Testing adding a new user"
    (let [user
          {:id 1
           :first_name "Bob"
           :last_name "Bobberton"
           :country_code "CA"
           :pass "secret"}]
      (is (= 1 (add-user! user)))
      ;;example of a failing test
      (is (= {:pass "secret", :country_code "CA", :last_name "Bobberton", :first_name "Bob", :id 2}
             (get-user 1))))))

(deftest test-country-codes
  (is (= [{:count 0}]
         (users-by-country {:country_code ["CA"]}))))


