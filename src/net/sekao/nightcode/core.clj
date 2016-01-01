(ns net.sekao.nightcode.core
  (:require [clojure.java.io :refer [resource]])
  (:import [javafx.application Application]
           [javafx.fxml FXMLLoader]
           [javafx.stage Stage StageBuilder]
           [javafx.scene Scene])
  (:gen-class :extends javafx.application.Application))

(defn -start [app ^Stage stage]
  (let [root (FXMLLoader/load (clojure.java.io/resource "main.fxml"))
        scene (Scene. root 800 600)
        editor (.lookup scene "#editor")
        engine (.getEngine editor)]
    (doto stage
      (.setTitle "Nightcode")
      (.setScene scene)
      (.show))
    (.load engine (.toExternalForm (resource "public/index.html")))))

(defn -main [& args]
  (Application/launch net.sekao.nightcode.core (into-array String args)))

(defn main [& args]
  (apply -main args))