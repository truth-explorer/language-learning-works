;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-abbr-reader.ss" "lang")((modname |iterative factorial|) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
(define(factorial n)
  (iter 1 2 n))
(define (iter a b c)
  (if (> b c)
      a (iter (* a b) (+ b 1) c)))
      
  
