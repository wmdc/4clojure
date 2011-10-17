; Generates Roman numerals from an integer for 4clojure problem #104

; see http://www.numericana.com/answer/roman.htm#valid


; Here's a first pass without the subtractive principle

(defn numerals [n]
	(let [v { \M 1000, \D 500, \C 100, 
            \L 50,   \X 10,  \V 5, 
            \I 1 }]
	   
	 (loop [k (keys v), s "", m n]
      (if (empty? k) s
          (let [y (v (first k))
                i (int (/ m y))]
              ;(println "char " y i "rem: " (- m i))
              (recur (rest k)
                 (str s (apply str (repeat i (first k))))
                 (- m (* i y))))))))
                 
; anonymous fn for 4clojure

