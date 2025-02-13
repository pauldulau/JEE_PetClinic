/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Simple JavaBean domain object representing a memo.
 *
 * @author Helena Berger
 */
@Entity
@Table(name = "memos")
public class Memo extends BaseEntity {

    /**
     * Holds value of property date.
     */
    @Column(name = "memo_date")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private DateTime date;

    /**
     * Holds value of property description.
     */
    @NotEmpty
    @Column(name = "description")
    private String description;

    /**
     * Holds value of property vet.
     */
    @ManyToOne
    @JoinColumn(name = "vet_id")
    private Vet vet;


    /**
     * Creates a new instance of Memo for the current date
     */
    public Memo() {
        this.date = new DateTime();
    }


    /**
     * Getter for property date.
     *
     * @return Value of property date.
     */
    public DateTime getDate() {
        return this.date;
    }

    /**
     * Setter for property date.
     *
     * @param date New value of property date.
     */
    public void setDate(DateTime date) {
        this.date = date;
    }

    /**
     * Getter for property description.
     *
     * @return Value of property description.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Setter for property description.
     *
     * @param description New value of property description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter for property vet.
     *
     * @return Value of property vet.
     */
    public Vet getVet() {
        return this.vet;
    }

    /**
     * Setter for property vet.
     *
     * @param vet New value of property vet.
     */
    public void setVet(Vet vet) {
        this.vet = vet;
    }

}
