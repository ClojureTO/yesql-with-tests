(ns yesql-examples.core
  (:require
   [clojure.java.jdbc :as sql]
   [yesql.core :refer [defqueries]]))

(def db-spec
  {:classname   "org.h2.Driver"
   :connection-uri "jdbc:h2:./store.db"})

(defn create-user-table [db]
  (sql/db-do-commands
   db (sql/create-table-ddl
       :users
       [:id :int "PRIMARY KEY AUTO_INCREMENT"]
       [:first_name "VARCHAR(32)"]
       [:last_name "VARCHAR(32)"]
       [:country_code "VARCHAR(2)"]
       [:pass "VARCHAR(100)"])))

(defqueries "queries.sql" {:connection db-spec})

(defn get-user [id]
  (first (get-user* {:id id})))




