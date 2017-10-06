package com.entities;

public class PortScan {

        private int Id;
        private String FirstName;
        private String LastName;

        public PortScan()
        {

        }
        public PortScan(String firstName, String lastName)
        {
            this.FirstName = firstName;
            this.LastName = lastName;
        }

        public int getId() {
            return Id;
        }

        public void setId(int id) {
            Id = id;
        }

        public String getFirstName() {
            return FirstName;
        }

        public void setFirstName(String firstName) {
            FirstName = firstName;
        }

        public String getLastName() {
            return LastName;
        }

        public void setLastName(String lastName) {
            LastName = lastName;
        }
    }
