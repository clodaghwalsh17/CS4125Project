package com.castletroymedical.billing;

import com.castletroymedical.billing.invoice.Consultation;
import com.castletroymedical.billing.invoice.InsuredInvoice;
import com.castletroymedical.billing.invoice.Invoice;
import com.castletroymedical.billing.invoice.MedicalCardInvoice;
import com.castletroymedical.billing.invoice.Monitoring;
import com.castletroymedical.billing.invoice.PrivateInvoice;
import com.castletroymedical.billing.invoice.PrivateRoom;
import com.castletroymedical.billing.invoice.Procedure;
import com.castletroymedical.billing.invoice.WardBed;

public class InvoiceBuilder extends Builder {
    
    public InvoiceBuilder(String type){ 
        this.invoice = invoiceFactory(type);
    }

    public Invoice invoiceFactory(String type){
        if(type == null || type.isEmpty())
            return null;

        Invoice out;
        type = type.toLowerCase();
        switch(type) {
            case "insured": out = new InsuredInvoice(); break;
            case "medical card": out = new MedicalCardInvoice(); break;
            default: out = new PrivateInvoice(); break;
        }
        return out;
    }

    @Override
    public void buildConsultation() {
        this.invoice = new Consultation(this.invoice);
    }

    @Override
    public void buildMonitoring() {
        this.invoice = new Monitoring(this.invoice);
    }

    @Override
    public void buildMonitoring(int days) {
        this.invoice = new Monitoring(days, this.invoice);
    }

    @Override
    public void buildPrivateRoom() {
        this.invoice = new PrivateRoom(this.invoice);
    }

    @Override
    public void buildPrivateRoom(int days) {
        this.invoice = new PrivateRoom(days, this.invoice);
    }

    @Override
    public void buildProcedure(String name) {
        this.invoice = new Procedure(name, this.invoice);
    }

    @Override
    public void buildWardBed() {
        this.invoice = new WardBed(this.invoice);
    }

    @Override
    public void buildWardBed(int days) {
        this.invoice = new WardBed(days, this.invoice);;
    }

    @Override
    public Invoice getInvoice() { 
        return this.invoice;
    }

}
