(ns thi.ng.math.test.macros
  #?@(:clj
      [(:require
        [clojure.test :refer :all]
        [thi.ng.math.macros :as mm])]
      :cljs
      [(:require-macros
        [thi.ng.math.macros :as mm])
       (:require
        [cemerick.cljs.test :refer-macros [is deftest]])]))

(deftest test-add
  (is (== 5 (mm/add 2.0 3.0)))
  (is (== 9 (mm/add 2.0 3.0 4.0)))
  (is (== 14 (mm/add 2.0 3.0 4.0 5.0)))
  (is (== 20 (mm/add 2.0 3.0 4.0 5.0 6.0)))
  (is (== 27 (mm/add 2.0 3.0 4.0 5.0 6.0 7.0)))
  (is (== 35 (mm/add 2.0 3.0 4.0 5.0 6.0 7.0 8.0)))
  (is (== 44 (mm/add 2.0 3.0 4.0 5.0 6.0 7.0 8.0 9.0))))

(deftest test-sub
  (is (== -1 (mm/sub 2.0 3.0)))
  (is (== -5 (mm/sub 2.0 3.0 4.0)))
  (is (== -10 (mm/sub 2.0 3.0 4.0 5.0)))
  (is (== -16 (mm/sub 2.0 3.0 4.0 5.0 6.0)))
  (is (== -23 (mm/sub 2.0 3.0 4.0 5.0 6.0 7.0)))
  (is (== -31 (mm/sub 2.0 3.0 4.0 5.0 6.0 7.0 8.0)))
  (is (== -40 (mm/sub 2.0 3.0 4.0 5.0 6.0 7.0 8.0 9.0))))

(deftest test-mul
  (is (== 6 (mm/mul 2.0 3.0)))
  (is (== 24 (mm/mul 2.0 3.0 4.0)))
  (is (== 120 (mm/mul 2.0 3.0 4.0 5.0)))
  (is (== 720 (mm/mul 2.0 3.0 4.0 5.0 6.0)))
  (is (== 5040 (mm/mul 2.0 3.0 4.0 5.0 6.0 7.0)))
  (is (== 40320 (mm/mul 2.0 3.0 4.0 5.0 6.0 7.0 8.0)))
  (is (== 362880 (mm/mul 2.0 3.0 4.0 5.0 6.0 7.0 8.0 9.0))))

(deftest test-div
  (is (== (/ 2.0 3.0) (mm/div 2.0 3.0)))
  (is (== (/ 2.0 3.0 4.0) (mm/div 2.0 3.0 4.0)))
  (is (== (/ 2.0 3.0 4.0 5.0) (mm/div 2.0 3.0 4.0 5.0)))
  (is (== (/ 2.0 3.0 4.0 5.0 6.0) (mm/div 2.0 3.0 4.0 5.0 6.0)))
  (is (== (/ 2.0 3.0 4.0 5.0 6.0 7.0) (mm/div 2.0 3.0 4.0 5.0 6.0 7.0)))
  (is (== (/ 2.0 3.0 4.0 5.0 6.0 7.0 8.0) (mm/div 2.0 3.0 4.0 5.0 6.0 7.0 8.0)))
  (is (== (/ 2.0 3.0 4.0 5.0 6.0 7.0 8.0 9.0) (mm/div 2.0 3.0 4.0 5.0 6.0 7.0 8.0 9.0))))

(deftest test-madd
  (is (== 10 (mm/madd 2.0 3.0 4.0)))
  (is (== 26 (mm/madd 2.0 3.0 4.0 5.0)))
  (is (== 32 (mm/madd 2.0 3.0 4.0 5.0 6.0)))
  (is (== 68 (mm/madd 2.0 3.0 4.0 5.0 6.0 7.0)))
  (is (== 76 (mm/madd 2.0 3.0 4.0 5.0 6.0 7.0 8.0)))
  (is (== 140 (mm/madd 2.0 3.0 4.0 5.0 6.0 7.0 8.0 9.0))))

(deftest test-msub
  (is (== 2 (mm/msub 2.0 3.0 4.0)))
  (is (== -14 (mm/msub 2.0 3.0 4.0 5.0)))
  (is (== -20 (mm/msub 2.0 3.0 4.0 5.0 6.0)))
  (is (== -56 (mm/msub 2.0 3.0 4.0 5.0 6.0 7.0)))
  (is (== -64 (mm/msub 2.0 3.0 4.0 5.0 6.0 7.0 8.0)))
  (is (== -128 (mm/msub 2.0 3.0 4.0 5.0 6.0 7.0 8.0 9.0))))

(deftest test-addm
  (is (== 20 (mm/addm 2.0 3.0 4.0)))
  (is (== 45 (mm/addm 2.0 3.0 4.0 5.0)))
  (is (== 270 (mm/addm 2.0 3.0 4.0 5.0 6.0)))
  (is (== 585 (mm/addm 2.0 3.0 4.0 5.0 6.0 7.0)))
  (is (== 4680 (mm/addm 2.0 3.0 4.0 5.0 6.0 7.0 8.0)))
  (is (== 9945 (mm/addm 2.0 3.0 4.0 5.0 6.0 7.0 8.0 9.0))))

(deftest test-adddiv
  (is (== (/ 5.0 4.0) (mm/adddiv 2.0 3.0 4.0)))
  (is (== (/ 5.0 9.0) (mm/adddiv 2.0 3.0 4.0 5.0)))
  (is (== (/ 5.0 9.0 6.0) (mm/adddiv 2.0 3.0 4.0 5.0 6.0)))
  (is (== (/ 5.0 9.0 13.0) (mm/adddiv 2.0 3.0 4.0 5.0 6.0 7.0)))
  (is (== (/ 5.0 9.0 13.0 8.0) (mm/adddiv 2.0 3.0 4.0 5.0 6.0 7.0 8.0)))
  (is (== (/ 5.0 9.0 13.0 17.0) (mm/adddiv 2.0 3.0 4.0 5.0 6.0 7.0 8.0 9.0))))

(deftest test-subm
  (is (== -4 (mm/subm 2.0 3.0 4.0)))
  (is (== 1 (mm/subm 2.0 3.0 4.0 5.0)))
  (is (== 6 (mm/subm 2.0 3.0 4.0 5.0 6.0)))
  (is (== -1 (mm/subm 2.0 3.0 4.0 5.0 6.0 7.0)))
  (is (== -8 (mm/subm 2.0 3.0 4.0 5.0 6.0 7.0 8.0)))
  (is (== 1 (mm/subm 2.0 3.0 4.0 5.0 6.0 7.0 8.0 9.0))))

(deftest test-subdiv
  (is (== (/ -1.0 4.0) (mm/subdiv 2.0 3.0 4.0)))
  (is (== (/ -1.0 -1.0) (mm/subdiv 2.0 3.0 4.0 5.0)))
  (is (== (/ -1.0 -1.0 6.0) (mm/subdiv 2.0 3.0 4.0 5.0 6.0)))
  (is (== (/ -1.0 -1.0 -1.0) (mm/subdiv 2.0 3.0 4.0 5.0 6.0 7.0)))
  (is (== (/ -1.0 -1.0 -1.0 8.0) (mm/subdiv 2.0 3.0 4.0 5.0 6.0 7.0 8.0)))
  (is (== (/ -1.0 -1.0 -1.0 -1.0) (mm/subdiv 2.0 3.0 4.0 5.0 6.0 7.0 8.0 9.0))))

(deftest test-maddsub
  (is (== 5 (mm/maddsub 2.0 3.0 4.0 5.0)))
  (is (== 20 (mm/maddsub 2.0 3.0 4.0 5.0 6.0)))
  (is (== -16 (mm/maddsub 2.0 3.0 4.0 5.0 6.0 7.0)))
  (is (== 60 (mm/maddsub 2.0 3.0 4.0 5.0 6.0 7.0 8.0)))
  (is (== -4 (mm/maddsub 2.0 3.0 4.0 5.0 6.0 7.0 8.0 9.0))))

(deftest test-msubadd
  (is (== 7 (mm/msubadd 2.0 3.0 4.0 5.0)))
  (is (== -8 (mm/msubadd 2.0 3.0 4.0 5.0 6.0)))
  (is (== 28 (mm/msubadd 2.0 3.0 4.0 5.0 6.0 7.0)))
  (is (== -48 (mm/msubadd 2.0 3.0 4.0 5.0 6.0 7.0 8.0)))
  (is (== 16 (mm/msubadd 2.0 3.0 4.0 5.0 6.0 7.0 8.0 9.0))))

(deftest test-addmsub
  (is (== 15 (mm/addmsub 2.0 3.0 4.0 5.0)))
  (is (== 39 (mm/addmsub 2.0 3.0 4.0 5.0 6.0)))
  (is (== 3 (mm/addmsub 2.0 3.0 4.0 5.0 6.0 7.0)))
  (is (== 577 (mm/addmsub 2.0 3.0 4.0 5.0 6.0 7.0 8.0)))
  (is (== 513 (mm/addmsub 2.0 3.0 4.0 5.0 6.0 7.0 8.0 9.0))))

(deftest test-submadd
  (is (== 1 (mm/submadd 2.0 3.0 4.0 5.0)))
  (is (== 7 (mm/submadd 2.0 3.0 4.0 5.0 6.0)))
  (is (== 43 (mm/submadd 2.0 3.0 4.0 5.0 6.0 7.0)))
  (is (== 7 (mm/submadd 2.0 3.0 4.0 5.0 6.0 7.0 8.0)))
  (is (== 71 (mm/submadd 2.0 3.0 4.0 5.0 6.0 7.0 8.0 9.0))))
(deftest bitmask
  (is (= 0x01 (mm/bitmask pos? 1)))
  (is (= 0x03 (mm/bitmask pos? 1 1)))
  (is (= 0x07 (mm/bitmask pos? 1 1 1)))
  (is (= 0x0f (mm/bitmask pos? 1 1 1 1)))
  (is (= 0x1f (mm/bitmask pos? 1 1 1 1 1)))
  (is (= 0x3f (mm/bitmask pos? 1 1 1 1 1 1)))
  (is (= 0x7f (mm/bitmask pos? 1 1 1 1 1 1 1)))
  (is (= 0xff (mm/bitmask pos? 1 1 1 1 1 1 1 1)))
  (is (= 0x55 (mm/bitmask pos? 1 0 1 0 1 0 1 0)))
  (is (= 0xaa (mm/bitmask pos? 0 1 0 1 0 1 0 1))))
(deftest mix
  (is (= 0.5  (mm/mix 0 1 0.5)))
  (is (= 1.5  (mm/mix 0 1 2 3 0.5 0.5)))
  (is (= 3.5  (mm/mix 0 1 2 3 4 5 6 7 0.5 0.5 0.5))))
