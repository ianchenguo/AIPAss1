/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aviationhub.business.DTO.Activity;

/**
 *
 * @author ian
 */
public enum ActivityProviderEnum {
    BANKSTOWNAVIATIONCLUB("Bankstown Aviation Club"),
    BLACKTOWNFLYINGSCHOOL("Blacktown Flying School");
    
    private final String providerAsString;
    private ActivityProviderEnum (String providerAsString) {
        this.providerAsString = providerAsString;
    }
    
    @Override
    public String toString(){
        return this.providerAsString;
    }
}
