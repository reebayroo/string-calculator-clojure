(ns string-calculator.core-test
  (:require [string-calculator.core :refer :all]
            [expectations :refer :all]))

(expect 0 (sum-a-string ""))
(expect 1 (sum-a-string "1"))
;;two numbers separated by comma

(expect 3 (sum-a-string "2,1"))

(expect 51 (sum-a-string "1,20,30"))

;;Any amount of comma separated numbers should summed
(expect 15 (sum-a-string "1,2,3,4,5"))

;;New line character should be treated as a separator
(expect 6 (sum-a-string "1\n2,3"))

;;Custom delimiters should be traded as separators
(expect 3 (sum-a-string "//;1;2"))


;; Numbers bigger than 1000 should be ignored
(expect 2 (sum-a-string "1001,2"))


;; Negative numbers should throw exception
(expect Exception (sum-a-string "-1,2"))
(expect Exception (sum-a-string "2,-105"))

;; Multiple character delimiter
(expect 103 (sum-a-string "101*****2"))
(expect 103 (sum-a-string "\n101**\n***2"))

;;todo fix support for a dash delimiter
;;(expect 103 (sum-a-string "//[-]\n101-2"))
