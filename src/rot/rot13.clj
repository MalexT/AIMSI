(ns rot.rot13)

(defn rotate [string rotor]
  (letfn [(rot [c]
            (let [v (int c)]
              (cond
                (<= (int \a) v (int \z))
                (char (+ (int \a) (mod (+ (- v (int \a)) rotor) 26)))
                (<= (int \A) v (int \Z))
                (char (+ (int \A) (mod (+ (- v (int \A)) rotor) 26)))
                (<= 48 v 57)
                (char (+ 48 (mod (+ (- v 48) rotor) 10)))
                :else c)))]
    (apply str (map rot string))))