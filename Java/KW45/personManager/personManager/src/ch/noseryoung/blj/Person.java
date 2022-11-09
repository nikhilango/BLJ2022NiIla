package ch.noseryoung.blj;

public class Person {
    private String firstname;
    private String lastname;
    private String gender;
    private String favfood;
    private String email;

    public Person(String firstname,String lastname,String gender, String favfood, String email){
        this.firstname = firstname;
        this.lastname = lastname;
        this.favfood = favfood;
        this.email = email;
        this.gender = gender;
    }

    public void presentYourself(){
        String pronoun;

        if (gender.equals("male")){
            pronoun = "his";
        }
        else if(gender.equals("female")){
            pronoun = "her";
        }
        else {
            pronoun = "their";
        }


        System.out.println(pronoun + " name is " + firstname +" "+ lastname + " and " +pronoun+" favourite food is " + favfood + "." );
            System.out.println(pronoun + " E-Mail address:  "+ email);

        System.out.println("\n");
    }
}
