(ns string-calculator.core
  [require [clojure.string :as str]])


(defn- extract->delimiter [string]
    (first (re-seq #"\[\w]" string)))



(defn- string->numbers [string]
  (map #(Integer. %) (re-seq #"[-?\d]+" string)))

(defn sum-a-string [string]
    (let [numbers (string->numbers string)]
      (when-let [negative-numbers (not-empty (filter neg? numbers))]
        (print "negative-numbers")
        (throw (Exception. (str "Negative not allowed: " negative-numbers))))
      (reduce  + (filter #(< % 1000) numbers))))

