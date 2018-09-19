;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-abbr-reader.ss" "lang")((modname |iterative fibonacci|) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
(define(fibo n)
  (iter 1 0 n))
(define (iter a b count)
  (if (= count 0)
      b
      (iter (+ a b) a (- count 1))))