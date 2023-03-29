package service;

import entity.Author;

public  class AuthorService extends Author {

    public AuthorService() {
    }

    public void register (int id,String firstName, String lastName, int age) {
        super.setId(id);
        super.setFirstName(firstName);
        super.setLastName(lastName);
        super.setAge(age);
    }


}
