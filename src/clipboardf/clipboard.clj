(ns clipboardf.clipboard)

(defn get-clipboard []
  (.getSystemClipboard (java.awt.Toolkit/getDefaultToolkit)))

(defn spit-clipboard 
  "Not working properly. This needs to be fixed."
  [text]
  (.setContents (get-clipboard) (java.awt.datatransfer.StringSelection. text) nil))