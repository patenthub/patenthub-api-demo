package com.patenthub.api.entity;

import java.util.List;
import java.util.Map;

public class EnterprisePortrait {

    private Map<String,Long> legalMap;
    private Map<String,Long> typeMap;
    private Map<String,Map<String,Long>> legalApplicationYearMap;
    private Map<String,Long> areaMap;
    private Map<String,Map<String,Long>> areaYearMap;
    private List<KeyValue> ipcKeyValueList;
    private Map<Integer,String> compareMap;
    private Map<String,Long> applicationYearMap;
    private Map<String,Long> publicationYearMap;
    private Map<String,Long> grantYearMap;
    private List<KeyValue> inventorKeyValueList;

    public EnterprisePortrait(Map<String, Long> legalMap, Map<String, Long> typeMap, Map<String, Map<String, Long>> legalApplicationYearMap, Map<String, Long> areaMap, Map<String, Map<String, Long>> areaYearMap, List<KeyValue> ipcKeyValueList, Map<Integer, String> compareMap, Map<String, Long> applicationYearMap, Map<String, Long> publicationYearMap, Map<String, Long> grantYearMap, List<KeyValue> inventorKeyValueList) {
        this.legalMap = legalMap;
        this.typeMap = typeMap;
        this.legalApplicationYearMap = legalApplicationYearMap;
        this.areaMap = areaMap;
        this.areaYearMap = areaYearMap;
        this.ipcKeyValueList = ipcKeyValueList;
        this.compareMap = compareMap;
        this.applicationYearMap = applicationYearMap;
        this.publicationYearMap = publicationYearMap;
        this.grantYearMap = grantYearMap;
        this.inventorKeyValueList = inventorKeyValueList;
    }

    public Map<String, Long> getLegalMap() {
        return legalMap;
    }

    public void setLegalMap(Map<String, Long> legalMap) {
        this.legalMap = legalMap;
    }

    public Map<String, Long> getTypeMap() {
        return typeMap;
    }

    public void setTypeMap(Map<String, Long> typeMap) {
        this.typeMap = typeMap;
    }

    public Map<String, Map<String, Long>> getLegalApplicationYearMap() {
        return legalApplicationYearMap;
    }

    public void setLegalApplicationYearMap(Map<String, Map<String, Long>> legalApplicationYearMap) {
        this.legalApplicationYearMap = legalApplicationYearMap;
    }

    public Map<String, Long> getAreaMap() {
        return areaMap;
    }

    public void setAreaMap(Map<String, Long> areaMap) {
        this.areaMap = areaMap;
    }

    public Map<String, Map<String, Long>> getAreaYearMap() {
        return areaYearMap;
    }

    public void setAreaYearMap(Map<String, Map<String, Long>> areaYearMap) {
        this.areaYearMap = areaYearMap;
    }

    public Map<Integer, String> getCompareMap() {
        return compareMap;
    }

    public void setCompareMap(Map<Integer, String> compareMap) {
        this.compareMap = compareMap;
    }

    public Map<String, Long> getApplicationYearMap() {
        return applicationYearMap;
    }

    public void setApplicationYearMap(Map<String, Long> applicationYearMap) {
        this.applicationYearMap = applicationYearMap;
    }

    public Map<String, Long> getPublicationYearMap() {
        return publicationYearMap;
    }

    public void setPublicationYearMap(Map<String, Long> publicationYearMap) {
        this.publicationYearMap = publicationYearMap;
    }

    public Map<String, Long> getGrantYearMap() {
        return grantYearMap;
    }

    public void setGrantYearMap(Map<String, Long> grantYearMap) {
        this.grantYearMap = grantYearMap;
    }

    public List<KeyValue> getIpcKeyValueList() {
        return ipcKeyValueList;
    }

    public void setIpcKeyValueList(List<KeyValue> ipcKeyValueList) {
        this.ipcKeyValueList = ipcKeyValueList;
    }

    public List<KeyValue> getInventorKeyValueList() {
        return inventorKeyValueList;
    }

    public void setInventorKeyValueList(List<KeyValue> inventorKeyValueList) {
        this.inventorKeyValueList = inventorKeyValueList;
    }
}
