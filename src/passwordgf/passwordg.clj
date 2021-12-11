(ns passwordgf.passwordg)


(defn password-generator
  "Generates random, secure, password based on number of characters that user requires.
   If none are passed then it defaults to 8"
  ([] (password-generator 8))
  ([n]
   (let [chars-between #(map char (range (int %1) (inc (int %2))))
         chars (concat (chars-between \0 \9)
                       (chars-between \a \z)
                       (chars-between \A \Z)
                       [\_])
         password (take n (repeatedly #(rand-nth chars)))]
     (reduce str password))))