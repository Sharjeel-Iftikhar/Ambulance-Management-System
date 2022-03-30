/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMS;

/**
 *
 * @author Aadi
 */
public class InitialTest {
    private String Question;
    private String Type;
    private String Op1,Op2,Op3,Op4;
    private String Correct;
    
    // Getters of the attributes

    public String getQuestion() {
        return Question;
    }

    public String getOp1() {
        return Op1;
    }

    public String getOp2() {
        return Op2;
    }

    public String getOp3() {
        return Op3;
    }

    public String getOp4() {
        return Op4;
    }

    public String getCorrect() {
        return Correct;
    }
   
    public String getType()
    {
        return Type;
    }

    public InitialTest(String Question, String Type, String Op1, String Op2, String Op3, String Op4, String Correct) {
        this.Question = Question;
        this.Type = Type;
        this.Op1 = Op1;
        this.Op2 = Op2;
        this.Op3 = Op3;
        this.Op4 = Op4;
        this.Correct = Correct;
    }
    
}
