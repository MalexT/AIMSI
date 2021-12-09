(defproject aimsi "0.1.0-SNAPSHOT"
  :description "FIXME: CLI for ciphering and deciphering text provided by user, with different ciphers.
                Caesars, Vigenere, ROT13, Affine..."
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.3"]
                 [hickory "0.7.1"]
                 [clj-commons/spinner "0.6.0"]
                 [clojure-interop/java.awt "1.0.5"]]
  :main ^:skip-aot aimsi.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
