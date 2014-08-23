/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aviationhub.business.activity.factory;

/**
 *
 * @author ian
 */
public enum ActivityProvider {
    BANKSTOWNAVIATIONCLUB("Bankstown Aviation Club"),
    BLACKTOWNFLYINGSCHOOL("Blacktown Flying School");
    
    private final String providerAsString;
    private ActivityProvider(String providerAsString) {
        this.providerAsString = providerAsString;
    }
    
    @Override
    public String toString(){
        return this.providerAsString;
    }
}
