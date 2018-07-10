/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author idrieskysia
 */
public class TestQuestion {
        public int QNumber;
        public String QQuestion;
        public String html;
        public boolean[] Answer;
        public TestQuestion(){

        }
        public TestQuestion(int n, String q){
            QNumber=n;
            QQuestion = q;
        }
        public TestQuestion(int n, String q, boolean[] a){
            QNumber=n;
            QQuestion = q;
            Answer = a;
        }
}
