/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package extradata;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

/**
 * @version 7.01
 * @author nextgen_team
 */
@Named("additionalData")
@RequestScoped
public class AdditionalData implements Serializable{
    private SelectItem[] vmss, maritals, otpaybills,infomarkups, sub1099, pagerate,
            params, nations, genders, overtimes, pierrates, relocas, referrals, usertypes, costsheets;
    
    @PostConstruct
    private void init(){
        vmss = new SelectItem[21];
        maritals = new SelectItem[7];
        otpaybills = new SelectItem[5];
        infomarkups = new SelectItem[12];
        sub1099 =  new SelectItem[2];
        pagerate =  new SelectItem[2];
        params =  new SelectItem[3];
        nations = new SelectItem[8];
        genders = new SelectItem[2];
        overtimes = new SelectItem[2];
        pierrates = new SelectItem[3];
        relocas = new SelectItem[3];
        referrals = new SelectItem[3];
        usertypes = new SelectItem[2];
        costsheets = new SelectItem[3];
        
        vmss[0]=new SelectItem("0","NONE");
        vmss[1]=new SelectItem("1","AGILE 1");
        vmss[2]=new SelectItem("2","IQNAVIGATOR");
        vmss[3]=new SelectItem("3","MANPOWER");
        vmss[4]=new SelectItem("4","GUIDANT");
        vmss[5]=new SelectItem("5","FIELDGLASS");
        vmss[6]=new SelectItem("6","ALLEGIS");
        vmss[7]=new SelectItem("7","KELLEY");
        vmss[8]=new SelectItem("8","BARTECH");
        vmss[9]=new SelectItem("9","KELLY SERVICES");
        vmss[10]=new SelectItem("10","BEELINE");
        vmss[11]=new SelectItem("11","TODAY'S STAFFING");
        vmss[12]=new SelectItem("12","IBRIDGE");
        vmss[13]=new SelectItem("13","SHIFTWISE");
        vmss[14]=new SelectItem("14","RANDSTAND");
        vmss[15]=new SelectItem("15","GEOLOGICS");
        vmss[16]=new SelectItem("16","PROUNLIMITED");
        vmss[17]=new SelectItem("17","KELLY SCIENTIFIC");
        vmss[18]=new SelectItem("18","ADDECO");
        vmss[19]=new SelectItem("19","VISION IT");
        vmss[20]=new SelectItem("20","VOLT");
        
        maritals[0]=new SelectItem("0","NONE");
        maritals[1]=new SelectItem("1","MARRIAGE");
        maritals[2]=new SelectItem("2","LIVING COMMON LAW");
        maritals[3]=new SelectItem("3","WIDOWED");
        maritals[4]=new SelectItem("4","SEPARATED");
        maritals[5]=new SelectItem("5","DIVORCIED");
        maritals[6]=new SelectItem("6","SINGLE");
        
        otpaybills[0]=new SelectItem("0","NONE");
        otpaybills[1]=new SelectItem("1","BILL RATE");
        otpaybills[2]=new SelectItem("2","OT PAY RATE");
        otpaybills[3]=new SelectItem("3","5% DISCOUNT-J&J");
        otpaybills[4]=new SelectItem("4","BILL RATE + 1/2 PAY RATE");
        
        infomarkups[0]=new SelectItem("0" ,"NONE");
        infomarkups[1]=new SelectItem("1" ,"NOT TO EXCEED 35%");
        infomarkups[2]=new SelectItem("2" ,"7.5% TAX FEE");
        infomarkups[3]=new SelectItem("3" ,"5% TAX FEE");
        infomarkups[4]=new SelectItem("4" ,"MARKUP VARIES SEE AM");
        infomarkups[5]=new SelectItem("5" ,"GENERIC CLIENT - FILL IN DATA");
        infomarkups[6]=new SelectItem("6" ,"HOURLY");
        infomarkups[7]=new SelectItem("7" ,"NOT TO EXCEED 50%");
        infomarkups[8]=new SelectItem("8" ,"$10.00");
        infomarkups[9]=new SelectItem("9" ,"$20.00");
        infomarkups[10]=new SelectItem("10" ,"FIXED MARK UP 32%");
        infomarkups[11]=new SelectItem("11" ,"NOT TO EXCEED 30%");
        
        sub1099[0]=new SelectItem("0","NO");
        sub1099[1]=new SelectItem("1","YES");
        
        pagerate[0]=new SelectItem("0","BILL RATE + 1/2 PAY RATE");
        pagerate[1]=new SelectItem("1","PERCENTAGE");
        
        params[0]=new SelectItem("0","CANDIDATE TYPE");
        params[1]=new SelectItem("1","SUB1099");
        params[2]=new SelectItem("2","BENEFIT HOURS");
        
        nations[0]= new SelectItem("AMERICAN","AMERICAN");
        nations[1]= new SelectItem("MEXICAN","MEXICAN");
        nations[2]= new SelectItem("PORTUGUESE","PORTUGUESE");
        nations[3]= new SelectItem("INDIAN","INDIAN");
        nations[4]= new SelectItem("GERMAN","GERMAN");
        nations[5]= new SelectItem("ARABIAN","ARABIAN");
        nations[6]= new SelectItem("FRENCH","FRENCH");
        nations[7]= new SelectItem("ITALIAN","ITALIAN");
        //...more...
        
        genders[0]=new SelectItem("0","FEMALE");
        genders[1]=new SelectItem("1","MALE");
        
        overtimes[0]=new SelectItem("0","YES-TIME & A HALF");
        overtimes[1]=new SelectItem("1","NO STRAIGHT TIME");
        
        pierrates[0]=new SelectItem("0","NONE");
        pierrates[1]=new SelectItem("1","DAILY RATE");
        pierrates[2]=new SelectItem("2","MONTHLY RATE");
        
        relocas[0]=new SelectItem("0","NONE");
        relocas[1]=new SelectItem("1","LIMITED (UP TO AMOUNT)");
        relocas[2]=new SelectItem("2","SELF MOVE (FLAT AMOUNT)");
        
        referrals[0]=new SelectItem("0","NONE");
        referrals[1]=new SelectItem("1","IT - $500");
        referrals[2]=new SelectItem("2","BSS $ 50");
        
        usertypes[0]=new SelectItem("0","GENERAL");
        usertypes[1]=new SelectItem("1","ADMINISTRATOR");
        
        costsheets[0]=new SelectItem("0","NEW HIRE");
        costsheets[1]=new SelectItem("1","RATE CHANGE");
        costsheets[2]=new SelectItem("2","COST CHANGE (EXPENSES, VISA, ETC)");
    }
    
    
    public AdditionalData(){
        init();
    }

    public SelectItem[] getParams() {
        return params;
    }

    public void setParams(SelectItem[] params) {
        this.params = params;
    }
    
    public SelectItem[] getVmss() {
        return vmss;
    }

    public SelectItem[] getMaritals() {
        return maritals;
    }

    public SelectItem[] getOtpaybills() {
        return otpaybills;
    }

    public SelectItem[] getInfomarkups() {
        return infomarkups;
    }

    public SelectItem[] getSub1099() {
        return sub1099;
    }

    public void setSub1099(SelectItem[] sub1099) {
        this.sub1099 = sub1099;
    }

    public SelectItem[] getPagerate() {
        return pagerate;
    }

    public void setPagerate(SelectItem[] pagerate) {
        this.pagerate = pagerate;
    }

    public SelectItem[] getNations() {
        return nations;
    }

    public void setNations(SelectItem[] nations) {
        this.nations = nations;
    }

    public SelectItem[] getGenders() {
        return genders;
    }

    public void setGenders(SelectItem[] genders) {
        this.genders = genders;
    }

    public SelectItem[] getOvertimes() {
        return overtimes;
    }

    public void setOvertimes(SelectItem[] overtimes) {
        this.overtimes = overtimes;
    }

    public SelectItem[] getPierrates() {
        return pierrates;
    }

    public void setPierrates(SelectItem[] pierrates) {
        this.pierrates = pierrates;
    }

    public SelectItem[] getRelocas() {
        return relocas;
    }

    public void setRelocas(SelectItem[] relocas) {
        this.relocas = relocas;
    }

    public SelectItem[] getReferrals() {
        return referrals;
    }

    public void setReferrals(SelectItem[] referrals) {
        this.referrals = referrals;
    }

    public SelectItem[] getUsertypes() {
        return usertypes;
    }

    public void setUsertypes(SelectItem[] usertypes) {
        this.usertypes = usertypes;
    }

    public SelectItem[] getCostsheets() {
        return costsheets;
    }

    public void setCostsheets(SelectItem[] costsheets) {
        this.costsheets = costsheets;
    }
    
}
