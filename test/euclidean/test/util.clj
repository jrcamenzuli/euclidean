(ns euclidean.test.util)

(def margin-of-error 0.01)

(defmulti approx=
  "True if two values are approximately equal."
  (fn [x _] (type x)))

(defmethod approx= Double [^double x ^double y]
  (>= margin-of-error (Math/abs (- x y))))

(defmethod approx= clojure.lang.Sequential [xs ys]
  (every? identity (map approx= xs ys)))

(defmethod approx= nil [xs ys]
  (nil? ys))
