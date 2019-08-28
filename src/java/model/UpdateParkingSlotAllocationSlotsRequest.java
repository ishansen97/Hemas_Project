/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Ishan
 */
public class UpdateParkingSlotAllocationSlotsRequest {
    private int allocation_Id;
    private int slot_no;

    public int getAllocation_Id() {
        return allocation_Id;
    }

    public void setAllocation_Id(int allocation_Id) {
        this.allocation_Id = allocation_Id;
    }

    public int getSlot_no() {
        return slot_no;
    }

    public void setSlot_no(int slot_no) {
        this.slot_no = slot_no;
    }
}
