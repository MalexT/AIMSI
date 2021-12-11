(ns clipboardf.clipboard)

;Fixed the problem
(defn spit-clipboard 
  "Coppies given argument to clipboard."
  [text]
  (-> (java.awt.Toolkit/getDefaultToolkit) .getSystemClipboard (.setContents (java.awt.datatransfer.StringSelection. text) nil)))