package uk.gov.dvla.osg.rpd.document.properties;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class DocumentProperty {
	
	private String docAVScanCount, docAddress1, docAddress2, docAddress3, 
	docAddress4, docAddress5, docAddress6, docAddress7, docAddressCity, 
	docAddressCityStateZip, docAddressCompany, docAddressCountry, 
	docAddressDeliveryPoint, docAddressFullName, docAddressOther, 
	docAddressPostalCode, docAddressPrimary, docAddressProvince, 
	docAddressSecondary, docAddressState, docAddressUrbanization, 
	docAddressZipCode, docChildJobID, docCombinedDocID, docCombinedDocument, 
	docCombinedOriginalJobID, docCombinedSequence, docDVLAAccountNo, docDVLAAddress1, 
	docDVLAAddress2, docDVLAAddress3, docDVLAAddress4, docDVLAAddress5, docDVLAAppName, 
	docDVLABatchType, docDVLAColour, docDVLADPS, docDVLADocType, docDVLAEndOfGroup, 
	docDVLAEndOfTray, docDVLAEnvelope, docDVLAFleetNo, docDVLAGroupId, docDVLAInsertPack, 
	docDVLALanguage, docDVLAMailerBarcode, docDVLAMailerFunctions, docDVLAMailingProduct, 
	docDVLAMailmarkBarcode, docDVLAMailsortCode, docDVLAName1, docDVLAName2, 
	docDVLAOTT, docDVLAOriginalBatchType, docDVLAOriginalRunDate, docDVLAOriginalRunNo, 
	docDVLAPaperSize, docDVLAPlex, docDVLAPostCode, docDVLARef, docDVLARef2, docDVLARunDate, 
	docDVLARunNo, docDVLASelectorName, docDVLASerialNo, docDVLASite, docDVLASortField, 
	docDVLAStationery, docDVLAStreamingCode, docDVLASubBatchType, docDVLATitle, 
	docDVLATotalPagesInGroup, docDataLen, docDataOffset, docDocSizePieceThickness, 
	docDocSizePieceWeight, docDueOut, docEmailAddress, docEmailSent, docID, 
	docInsertBinResults, docInsertBinTriggers, docInsertDisposition, docInsertDivertBin, 
	docInsertInserterID, docInsertIteration, docInsertOperatorID, 
	docInsertOriginalBarCode, docInsertPendingDisposition, docInsertRecipientName, 
	docInsertSequence, docInsertStatus, docInsertTimeStamp, docInserterStatusCode, 
	docInserterStatusCodeExtended, docMadeAvailableByJobId, docMemberNumber, 
	docOriginalFirstPage, docOriginalJobID, docOriginalPages, docOriginalSequence, 
	docOriginalSheets, docPDZSOriginalInputFile, docPersistentID, 
	docPostalAddressProcessingRC, docPostalCategory, docPostalChangeAddressRC, 
	docPostalContainerBreakMark, docPostalContainerNumber, 
	docPostalHandlingUnitBreakMark, docPostalHandlingUnitNumber, 
	docPostalPackageBreakMark, docPostalPackageNumber, docPostalPostageRate, 
	docPostalPostageRateCode, docPostalSequenceNumber, docPostalSequencingProcessingRC, 
	docPull, docPullProp, docSaveAll, docSequenceInChild, docSourceFileName, 
	docTTBarcodeScanTime1, docTTBarcodeScanTime2, docTTBarcodeScanTime3, 
	docTTBarcodeScanTime4, docTTBarcodeScanTime5, docTTBarcodeStatus1, 
	docTTBarcodeStatus2, docTTBarcodeStatus3, docTTBarcodeStatus4, docTTBarcodeStatus5, 
	docTTJobID, docVerificationRecipient, jobHostUserID, jobName;

	public String getDocAVScanCount() {
		return docAVScanCount;
	}
	public void setDocAVScanCount(String docAVScanCount) {
		this.docAVScanCount = docAVScanCount;
	}
	public String getDocAddress1() {
		return docAddress1;
	}
	public void setDocAddress1(String docAddress1) {
		this.docAddress1 = docAddress1;
	}
	public String getDocAddress2() {
		return docAddress2;
	}
	public void setDocAddress2(String docAddress2) {
		this.docAddress2 = docAddress2;
	}
	public String getDocAddress3() {
		return docAddress3;
	}
	public void setDocAddress3(String docAddress3) {
		this.docAddress3 = docAddress3;
	}
	public String getDocAddress4() {
		return docAddress4;
	}
	public void setDocAddress4(String docAddress4) {
		this.docAddress4 = docAddress4;
	}
	public String getDocAddress5() {
		return docAddress5;
	}
	public void setDocAddress5(String docAddress5) {
		this.docAddress5 = docAddress5;
	}
	public String getDocAddress6() {
		return docAddress6;
	}
	public void setDocAddress6(String docAddress6) {
		this.docAddress6 = docAddress6;
	}
	public String getDocAddress7() {
		return docAddress7;
	}
	public void setDocAddress7(String docAddress7) {
		this.docAddress7 = docAddress7;
	}
	public String getDocAddressCity() {
		return docAddressCity;
	}
	public void setDocAddressCity(String docAddressCity) {
		this.docAddressCity = docAddressCity;
	}
	public String getDocAddressCityStateZip() {
		return docAddressCityStateZip;
	}
	public void setDocAddressCityStateZip(String docAddressCityStateZip) {
		this.docAddressCityStateZip = docAddressCityStateZip;
	}
	public String getDocAddressCompany() {
		return docAddressCompany;
	}
	public void setDocAddressCompany(String docAddressCompany) {
		this.docAddressCompany = docAddressCompany;
	}
	public String getDocAddressCountry() {
		return docAddressCountry;
	}
	public void setDocAddressCountry(String docAddressCountry) {
		this.docAddressCountry = docAddressCountry;
	}
	public String getDocAddressDeliveryPoint() {
		return docAddressDeliveryPoint;
	}
	public void setDocAddressDeliveryPoint(String docAddressDeliveryPoint) {
		this.docAddressDeliveryPoint = docAddressDeliveryPoint;
	}
	public String getDocAddressFullName() {
		return docAddressFullName;
	}
	public void setDocAddressFullName(String docAddressFullName) {
		this.docAddressFullName = docAddressFullName;
	}
	public String getDocAddressOther() {
		return docAddressOther;
	}
	public void setDocAddressOther(String docAddressOther) {
		this.docAddressOther = docAddressOther;
	}
	public String getDocAddressPostalCode() {
		return docAddressPostalCode;
	}
	public void setDocAddressPostalCode(String docAddressPostalCode) {
		this.docAddressPostalCode = docAddressPostalCode;
	}
	public String getDocAddressPrimary() {
		return docAddressPrimary;
	}
	public void setDocAddressPrimary(String docAddressPrimary) {
		this.docAddressPrimary = docAddressPrimary;
	}
	public String getDocAddressProvince() {
		return docAddressProvince;
	}
	public void setDocAddressProvince(String docAddressProvince) {
		this.docAddressProvince = docAddressProvince;
	}
	public String getDocAddressSecondary() {
		return docAddressSecondary;
	}
	public void setDocAddressSecondary(String docAddressSecondary) {
		this.docAddressSecondary = docAddressSecondary;
	}
	public String getDocAddressState() {
		return docAddressState;
	}
	public void setDocAddressState(String docAddressState) {
		this.docAddressState = docAddressState;
	}
	public String getDocAddressUrbanization() {
		return docAddressUrbanization;
	}
	public void setDocAddressUrbanization(String docAddressUrbanization) {
		this.docAddressUrbanization = docAddressUrbanization;
	}
	public String getDocAddressZipCode() {
		return docAddressZipCode;
	}
	public void setDocAddressZipCode(String docAddressZipCode) {
		this.docAddressZipCode = docAddressZipCode;
	}
	public String getDocChildJobID() {
		return docChildJobID;
	}
	public void setDocChildJobID(String docChildJobID) {
		this.docChildJobID = docChildJobID;
	}
	public String getDocCombinedDocID() {
		return docCombinedDocID;
	}
	public void setDocCombinedDocID(String docCombinedDocID) {
		this.docCombinedDocID = docCombinedDocID;
	}
	public String getDocCombinedDocument() {
		return docCombinedDocument;
	}
	public void setDocCombinedDocument(String docCombinedDocument) {
		this.docCombinedDocument = docCombinedDocument;
	}
	public String getDocCombinedOriginalJobID() {
		return docCombinedOriginalJobID;
	}
	public void setDocCombinedOriginalJobID(String docCombinedOriginalJobID) {
		this.docCombinedOriginalJobID = docCombinedOriginalJobID;
	}
	public String getDocCombinedSequence() {
		return docCombinedSequence;
	}
	public void setDocCombinedSequence(String docCombinedSequence) {
		this.docCombinedSequence = docCombinedSequence;
	}
	public String getDocDVLAAccountNo() {
		return docDVLAAccountNo;
	}
	public void setDocDVLAAccountNo(String docDVLAAccountNo) {
		this.docDVLAAccountNo = docDVLAAccountNo;
	}
	public String getDocDVLAAddress1() {
		return docDVLAAddress1;
	}
	public void setDocDVLAAddress1(String docDVLAAddress1) {
		this.docDVLAAddress1 = docDVLAAddress1;
	}
	public String getDocDVLAAddress2() {
		return docDVLAAddress2;
	}
	public void setDocDVLAAddress2(String docDVLAAddress2) {
		this.docDVLAAddress2 = docDVLAAddress2;
	}
	public String getDocDVLAAddress3() {
		return docDVLAAddress3;
	}
	public void setDocDVLAAddress3(String docDVLAAddress3) {
		this.docDVLAAddress3 = docDVLAAddress3;
	}
	public String getDocDVLAAddress4() {
		return docDVLAAddress4;
	}
	public void setDocDVLAAddress4(String docDVLAAddress4) {
		this.docDVLAAddress4 = docDVLAAddress4;
	}
	public String getDocDVLAAddress5() {
		return docDVLAAddress5;
	}
	public void setDocDVLAAddress5(String docDVLAAddress5) {
		this.docDVLAAddress5 = docDVLAAddress5;
	}
	public String getDocDVLAAppName() {
		return docDVLAAppName;
	}
	public void setDocDVLAAppName(String docDVLAAppName) {
		this.docDVLAAppName = docDVLAAppName;
	}
	public String getDocDVLABatchType() {
		return docDVLABatchType;
	}
	public void setDocDVLABatchType(String docDVLABatchType) {
		this.docDVLABatchType = docDVLABatchType;
	}
	public String getDocDVLAColour() {
		return docDVLAColour;
	}
	public void setDocDVLAColour(String docDVLAColour) {
		this.docDVLAColour = docDVLAColour;
	}
	public String getDocDVLADPS() {
		return docDVLADPS;
	}
	public void setDocDVLADPS(String docDVLADPS) {
		this.docDVLADPS = docDVLADPS;
	}
	public String getDocDVLADocType() {
		return docDVLADocType;
	}
	public void setDocDVLADocType(String docDVLADocType) {
		this.docDVLADocType = docDVLADocType;
	}
	public String getDocDVLAEndOfGroup() {
		return docDVLAEndOfGroup;
	}
	public void setDocDVLAEndOfGroup(String docDVLAEndOfGroup) {
		this.docDVLAEndOfGroup = docDVLAEndOfGroup;
	}
	public String getDocDVLAEndOfTray() {
		return docDVLAEndOfTray;
	}
	public void setDocDVLAEndOfTray(String docDVLAEndOfTray) {
		this.docDVLAEndOfTray = docDVLAEndOfTray;
	}
	public String getDocDVLAEnvelope() {
		return docDVLAEnvelope;
	}
	public void setDocDVLAEnvelope(String docDVLAEnvelope) {
		this.docDVLAEnvelope = docDVLAEnvelope;
	}
	public String getDocDVLAFleetNo() {
		return docDVLAFleetNo;
	}
	public void setDocDVLAFleetNo(String docDVLAFleetNo) {
		this.docDVLAFleetNo = docDVLAFleetNo;
	}
	public String getDocDVLAGroupId() {
		return docDVLAGroupId;
	}
	public void setDocDVLAGroupId(String docDVLAGroupId) {
		this.docDVLAGroupId = docDVLAGroupId;
	}
	public String getDocDVLAInsertPack() {
		return docDVLAInsertPack;
	}
	public void setDocDVLAInsertPack(String docDVLAInsertPack) {
		this.docDVLAInsertPack = docDVLAInsertPack;
	}
	public String getDocDVLALanguage() {
		return docDVLALanguage;
	}
	public void setDocDVLALanguage(String docDVLALanguage) {
		this.docDVLALanguage = docDVLALanguage;
	}
	public String getDocDVLAMailerBarcode() {
		return docDVLAMailerBarcode;
	}
	public void setDocDVLAMailerBarcode(String docDVLAMailerBarcode) {
		this.docDVLAMailerBarcode = docDVLAMailerBarcode;
	}
	public String getDocDVLAMailerFunctions() {
		return docDVLAMailerFunctions;
	}
	public void setDocDVLAMailerFunctions(String docDVLAMailerFunctions) {
		this.docDVLAMailerFunctions = docDVLAMailerFunctions;
	}
	public String getDocDVLAMailingProduct() {
		return docDVLAMailingProduct;
	}
	public void setDocDVLAMailingProduct(String docDVLAMailingProduct) {
		this.docDVLAMailingProduct = docDVLAMailingProduct;
	}
	public String getDocDVLAMailmarkBarcode() {
		return docDVLAMailmarkBarcode;
	}
	public void setDocDVLAMailmarkBarcode(String docDVLAMailmarkBarcode) {
		this.docDVLAMailmarkBarcode = docDVLAMailmarkBarcode;
	}
	public String getDocDVLAMailsortCode() {
		return docDVLAMailsortCode;
	}
	public void setDocDVLAMailsortCode(String docDVLAMailsortCode) {
		this.docDVLAMailsortCode = docDVLAMailsortCode;
	}
	public String getDocDVLAName1() {
		return docDVLAName1;
	}
	public void setDocDVLAName1(String docDVLAName1) {
		this.docDVLAName1 = docDVLAName1;
	}
	public String getDocDVLAName2() {
		return docDVLAName2;
	}
	public void setDocDVLAName2(String docDVLAName2) {
		this.docDVLAName2 = docDVLAName2;
	}
	public String getDocDVLAOTT() {
		return docDVLAOTT;
	}
	public void setDocDVLAOTT(String docDVLAOTT) {
		this.docDVLAOTT = docDVLAOTT;
	}
	public String getDocDVLAOriginalBatchType() {
		return docDVLAOriginalBatchType;
	}
	public void setDocDVLAOriginalBatchType(String docDVLAOriginalBatchType) {
		this.docDVLAOriginalBatchType = docDVLAOriginalBatchType;
	}
	public String getDocDVLAOriginalRunDate() {
		return docDVLAOriginalRunDate;
	}
	public void setDocDVLAOriginalRunDate(String docDVLAOriginalRunDate) {
		this.docDVLAOriginalRunDate = docDVLAOriginalRunDate;
	}
	public String getDocDVLAOriginalRunNo() {
		return docDVLAOriginalRunNo;
	}
	public void setDocDVLAOriginalRunNo(String docDVLAOriginalRunNo) {
		this.docDVLAOriginalRunNo = docDVLAOriginalRunNo;
	}
	public String getDocDVLAPaperSize() {
		return docDVLAPaperSize;
	}
	public void setDocDVLAPaperSize(String docDVLAPaperSize) {
		this.docDVLAPaperSize = docDVLAPaperSize;
	}
	public String getDocDVLAPlex() {
		return docDVLAPlex;
	}
	public void setDocDVLAPlex(String docDVLAPlex) {
		this.docDVLAPlex = docDVLAPlex;
	}
	public String getDocDVLAPostCode() {
		return docDVLAPostCode;
	}
	public void setDocDVLAPostCode(String docDVLAPostCode) {
		this.docDVLAPostCode = docDVLAPostCode;
	}
	public String getDocDVLARef() {
		return docDVLARef;
	}
	public void setDocDVLARef(String docDVLARef) {
		this.docDVLARef = docDVLARef;
	}
	public String getDocDVLARef2() {
		return docDVLARef2;
	}
	public void setDocDVLARef2(String docDVLARef2) {
		this.docDVLARef2 = docDVLARef2;
	}
	public String getDocDVLARunDate() {
		return docDVLARunDate;
	}
	public void setDocDVLARunDate(String docDVLARunDate) {
		this.docDVLARunDate = docDVLARunDate;
	}
	public String getDocDVLARunNo() {
		return docDVLARunNo;
	}
	public void setDocDVLARunNo(String docDVLARunNo) {
		this.docDVLARunNo = docDVLARunNo;
	}
	public String getDocDVLASelectorName() {
		return docDVLASelectorName;
	}
	public void setDocDVLASelectorName(String docDVLASelectorName) {
		this.docDVLASelectorName = docDVLASelectorName;
	}
	public String getDocDVLASerialNo() {
		return docDVLASerialNo;
	}
	public void setDocDVLASerialNo(String docDVLASerialNo) {
		this.docDVLASerialNo = docDVLASerialNo;
	}
	public String getDocDVLASite() {
		return docDVLASite;
	}
	public void setDocDVLASite(String docDVLASite) {
		this.docDVLASite = docDVLASite;
	}
	public String getDocDVLASortField() {
		return docDVLASortField;
	}
	public void setDocDVLASortField(String docDVLASortField) {
		this.docDVLASortField = docDVLASortField;
	}
	public String getDocDVLAStationery() {
		return docDVLAStationery;
	}
	public void setDocDVLAStationery(String docDVLAStationery) {
		this.docDVLAStationery = docDVLAStationery;
	}
	public String getDocDVLAStreamingCode() {
		return docDVLAStreamingCode;
	}
	public void setDocDVLAStreamingCode(String docDVLAStreamingCode) {
		this.docDVLAStreamingCode = docDVLAStreamingCode;
	}
	public String getDocDVLASubBatchType() {
		return docDVLASubBatchType;
	}
	public void setDocDVLASubBatchType(String docDVLASubBatchType) {
		this.docDVLASubBatchType = docDVLASubBatchType;
	}
	public String getDocDVLATitle() {
		return docDVLATitle;
	}
	public void setDocDVLATitle(String docDVLATitle) {
		this.docDVLATitle = docDVLATitle;
	}
	public String getDocDVLATotalPagesInGroup() {
		return docDVLATotalPagesInGroup;
	}
	public void setDocDVLATotalPagesInGroup(String docDVLATotalPagesInGroup) {
		this.docDVLATotalPagesInGroup = docDVLATotalPagesInGroup;
	}
	public String getDocDataLen() {
		return docDataLen;
	}
	public void setDocDataLen(String docDataLen) {
		this.docDataLen = docDataLen;
	}
	public String getDocDataOffset() {
		return docDataOffset;
	}
	public void setDocDataOffset(String docDataOffset) {
		this.docDataOffset = docDataOffset;
	}
	public String getDocDocSizePieceThickness() {
		return docDocSizePieceThickness;
	}
	public void setDocDocSizePieceThickness(String docDocSizePieceThickness) {
		this.docDocSizePieceThickness = docDocSizePieceThickness;
	}
	public String getDocDocSizePieceWeight() {
		return docDocSizePieceWeight;
	}
	public void setDocDocSizePieceWeight(String docDocSizePieceWeight) {
		this.docDocSizePieceWeight = docDocSizePieceWeight;
	}
	public String getDocDueOut() {
		return docDueOut;
	}
	public void setDocDueOut(String docDueOut) {
		this.docDueOut = docDueOut;
	}
	public String getDocEmailAddress() {
		return docEmailAddress;
	}
	public void setDocEmailAddress(String docEmailAddress) {
		this.docEmailAddress = docEmailAddress;
	}
	public String getDocEmailSent() {
		return docEmailSent;
	}
	public void setDocEmailSent(String docEmailSent) {
		this.docEmailSent = docEmailSent;
	}
	public String getDocID() {
		return docID;
	}
	public void setDocID(String docID) {
		this.docID = docID;
	}
	public String getDocInsertBinResults() {
		return docInsertBinResults;
	}
	public void setDocInsertBinResults(String docInsertBinResults) {
		this.docInsertBinResults = docInsertBinResults;
	}
	public String getDocInsertBinTriggers() {
		return docInsertBinTriggers;
	}
	public void setDocInsertBinTriggers(String docInsertBinTriggers) {
		this.docInsertBinTriggers = docInsertBinTriggers;
	}
	public String getDocInsertDisposition() {
		return docInsertDisposition;
	}
	public void setDocInsertDisposition(String docInsertDisposition) {
		this.docInsertDisposition = docInsertDisposition;
	}
	public String getDocInsertDivertBin() {
		return docInsertDivertBin;
	}
	public void setDocInsertDivertBin(String docInsertDivertBin) {
		this.docInsertDivertBin = docInsertDivertBin;
	}
	public String getDocInsertInserterID() {
		return docInsertInserterID;
	}
	public void setDocInsertInserterID(String docInsertInserterID) {
		this.docInsertInserterID = docInsertInserterID;
	}
	public String getDocInsertIteration() {
		return docInsertIteration;
	}
	public void setDocInsertIteration(String docInsertIteration) {
		this.docInsertIteration = docInsertIteration;
	}
	public String getDocInsertOperatorID() {
		return docInsertOperatorID;
	}
	public void setDocInsertOperatorID(String docInsertOperatorID) {
		this.docInsertOperatorID = docInsertOperatorID;
	}
	public String getDocInsertOriginalBarCode() {
		return docInsertOriginalBarCode;
	}
	public void setDocInsertOriginalBarCode(String docInsertOriginalBarCode) {
		this.docInsertOriginalBarCode = docInsertOriginalBarCode;
	}
	public String getDocInsertPendingDisposition() {
		return docInsertPendingDisposition;
	}
	public void setDocInsertPendingDisposition(String docInsertPendingDisposition) {
		this.docInsertPendingDisposition = docInsertPendingDisposition;
	}
	public String getDocInsertRecipientName() {
		return docInsertRecipientName;
	}
	public void setDocInsertRecipientName(String docInsertRecipientName) {
		this.docInsertRecipientName = docInsertRecipientName;
	}
	public String getDocInsertSequence() {
		return docInsertSequence;
	}
	public void setDocInsertSequence(String docInsertSequence) {
		this.docInsertSequence = docInsertSequence;
	}
	public String getDocInsertStatus() {
		return docInsertStatus;
	}
	public void setDocInsertStatus(String docInsertStatus) {
		this.docInsertStatus = docInsertStatus;
	}
	public String getDocInsertTimeStamp() {
		return docInsertTimeStamp;
	}
	public void setDocInsertTimeStamp(String docInsertTimeStamp) {
		this.docInsertTimeStamp = docInsertTimeStamp;
	}
	public String getDocInserterStatusCode() {
		return docInserterStatusCode;
	}
	public void setDocInserterStatusCode(String docInserterStatusCode) {
		this.docInserterStatusCode = docInserterStatusCode;
	}
	public String getDocInserterStatusCodeExtended() {
		return docInserterStatusCodeExtended;
	}
	public void setDocInserterStatusCodeExtended(
			String docInserterStatusCodeExtended) {
		this.docInserterStatusCodeExtended = docInserterStatusCodeExtended;
	}
	public String getDocMadeAvailableByJobId() {
		return docMadeAvailableByJobId;
	}
	public void setDocMadeAvailableByJobId(String docMadeAvailableByJobId) {
		this.docMadeAvailableByJobId = docMadeAvailableByJobId;
	}
	public String getDocMemberNumber() {
		return docMemberNumber;
	}
	public void setDocMemberNumber(String docMemberNumber) {
		this.docMemberNumber = docMemberNumber;
	}
	public String getDocOriginalFirstPage() {
		return docOriginalFirstPage;
	}
	public void setDocOriginalFirstPage(String docOriginalFirstPage) {
		this.docOriginalFirstPage = docOriginalFirstPage;
	}
	public String getDocOriginalJobID() {
		return docOriginalJobID;
	}
	public void setDocOriginalJobID(String docOriginalJobID) {
		this.docOriginalJobID = docOriginalJobID;
	}
	public String getDocOriginalPages() {
		return docOriginalPages;
	}
	public void setDocOriginalPages(String docOriginalPages) {
		this.docOriginalPages = docOriginalPages;
	}
	public String getDocOriginalSequence() {
		return docOriginalSequence;
	}
	public void setDocOriginalSequence(String docOriginalSequence) {
		this.docOriginalSequence = docOriginalSequence;
	}
	public String getDocOriginalSheets() {
		return docOriginalSheets;
	}
	public void setDocOriginalSheets(String docOriginalSheets) {
		this.docOriginalSheets = docOriginalSheets;
	}
	public String getDocPDZSOriginalInputFile() {
		return docPDZSOriginalInputFile;
	}
	public void setDocPDZSOriginalInputFile(String docPDZSOriginalInputFile) {
		this.docPDZSOriginalInputFile = docPDZSOriginalInputFile;
	}
	public String getDocPersistentID() {
		return docPersistentID;
	}
	public void setDocPersistentID(String docPersistentID) {
		this.docPersistentID = docPersistentID;
	}
	public String getDocPostalAddressProcessingRC() {
		return docPostalAddressProcessingRC;
	}
	public void setDocPostalAddressProcessingRC(String docPostalAddressProcessingRC) {
		this.docPostalAddressProcessingRC = docPostalAddressProcessingRC;
	}
	public String getDocPostalCategory() {
		return docPostalCategory;
	}
	public void setDocPostalCategory(String docPostalCategory) {
		this.docPostalCategory = docPostalCategory;
	}
	public String getDocPostalChangeAddressRC() {
		return docPostalChangeAddressRC;
	}
	public void setDocPostalChangeAddressRC(String docPostalChangeAddressRC) {
		this.docPostalChangeAddressRC = docPostalChangeAddressRC;
	}
	public String getDocPostalContainerBreakMark() {
		return docPostalContainerBreakMark;
	}
	public void setDocPostalContainerBreakMark(String docPostalContainerBreakMark) {
		this.docPostalContainerBreakMark = docPostalContainerBreakMark;
	}
	public String getDocPostalContainerNumber() {
		return docPostalContainerNumber;
	}
	public void setDocPostalContainerNumber(String docPostalContainerNumber) {
		this.docPostalContainerNumber = docPostalContainerNumber;
	}
	public String getDocPostalHandlingUnitBreakMark() {
		return docPostalHandlingUnitBreakMark;
	}
	public void setDocPostalHandlingUnitBreakMark(
			String docPostalHandlingUnitBreakMark) {
		this.docPostalHandlingUnitBreakMark = docPostalHandlingUnitBreakMark;
	}
	public String getDocPostalHandlingUnitNumber() {
		return docPostalHandlingUnitNumber;
	}
	public void setDocPostalHandlingUnitNumber(String docPostalHandlingUnitNumber) {
		this.docPostalHandlingUnitNumber = docPostalHandlingUnitNumber;
	}
	public String getDocPostalPackageBreakMark() {
		return docPostalPackageBreakMark;
	}
	public void setDocPostalPackageBreakMark(String docPostalPackageBreakMark) {
		this.docPostalPackageBreakMark = docPostalPackageBreakMark;
	}
	public String getDocPostalPackageNumber() {
		return docPostalPackageNumber;
	}
	public void setDocPostalPackageNumber(String docPostalPackageNumber) {
		this.docPostalPackageNumber = docPostalPackageNumber;
	}
	public String getDocPostalPostageRate() {
		return docPostalPostageRate;
	}
	public void setDocPostalPostageRate(String docPostalPostageRate) {
		this.docPostalPostageRate = docPostalPostageRate;
	}
	public String getDocPostalPostageRateCode() {
		return docPostalPostageRateCode;
	}
	public void setDocPostalPostageRateCode(String docPostalPostageRateCode) {
		this.docPostalPostageRateCode = docPostalPostageRateCode;
	}
	public String getDocPostalSequenceNumber() {
		return docPostalSequenceNumber;
	}
	public void setDocPostalSequenceNumber(String docPostalSequenceNumber) {
		this.docPostalSequenceNumber = docPostalSequenceNumber;
	}
	public String getDocPostalSequencingProcessingRC() {
		return docPostalSequencingProcessingRC;
	}
	public void setDocPostalSequencingProcessingRC(
			String docPostalSequencingProcessingRC) {
		this.docPostalSequencingProcessingRC = docPostalSequencingProcessingRC;
	}
	public String getDocPull() {
		return docPull;
	}
	public void setDocPull(String docPull) {
		this.docPull = docPull;
	}
	public String getDocPullProp() {
		return docPullProp;
	}
	public void setDocPullProp(String docPullProp) {
		this.docPullProp = docPullProp;
	}
	public String getDocSaveAll() {
		return docSaveAll;
	}
	public void setDocSaveAll(String docSaveAll) {
		this.docSaveAll = docSaveAll;
	}
	public String getDocSequenceInChild() {
		return docSequenceInChild;
	}
	public void setDocSequenceInChild(String docSequenceInChild) {
		this.docSequenceInChild = docSequenceInChild;
	}
	public String getDocSourceFileName() {
		return docSourceFileName;
	}
	public void setDocSourceFileName(String docSourceFileName) {
		this.docSourceFileName = docSourceFileName;
	}
	public String getDocTTBarcodeScanTime1() {
		return docTTBarcodeScanTime1;
	}
	public void setDocTTBarcodeScanTime1(String docTTBarcodeScanTime1) {
		this.docTTBarcodeScanTime1 = docTTBarcodeScanTime1;
	}
	public String getDocTTBarcodeScanTime2() {
		return docTTBarcodeScanTime2;
	}
	public void setDocTTBarcodeScanTime2(String docTTBarcodeScanTime2) {
		this.docTTBarcodeScanTime2 = docTTBarcodeScanTime2;
	}
	public String getDocTTBarcodeScanTime3() {
		return docTTBarcodeScanTime3;
	}
	public void setDocTTBarcodeScanTime3(String docTTBarcodeScanTime3) {
		this.docTTBarcodeScanTime3 = docTTBarcodeScanTime3;
	}
	public String getDocTTBarcodeScanTime4() {
		return docTTBarcodeScanTime4;
	}
	public void setDocTTBarcodeScanTime4(String docTTBarcodeScanTime4) {
		this.docTTBarcodeScanTime4 = docTTBarcodeScanTime4;
	}
	public String getDocTTBarcodeScanTime5() {
		return docTTBarcodeScanTime5;
	}
	public void setDocTTBarcodeScanTime5(String docTTBarcodeScanTime5) {
		this.docTTBarcodeScanTime5 = docTTBarcodeScanTime5;
	}
	public String getDocTTBarcodeStatus1() {
		return docTTBarcodeStatus1;
	}
	public void setDocTTBarcodeStatus1(String docTTBarcodeStatus1) {
		this.docTTBarcodeStatus1 = docTTBarcodeStatus1;
	}
	public String getDocTTBarcodeStatus2() {
		return docTTBarcodeStatus2;
	}
	public void setDocTTBarcodeStatus2(String docTTBarcodeStatus2) {
		this.docTTBarcodeStatus2 = docTTBarcodeStatus2;
	}
	public String getDocTTBarcodeStatus3() {
		return docTTBarcodeStatus3;
	}
	public void setDocTTBarcodeStatus3(String docTTBarcodeStatus3) {
		this.docTTBarcodeStatus3 = docTTBarcodeStatus3;
	}
	public String getDocTTBarcodeStatus4() {
		return docTTBarcodeStatus4;
	}
	public void setDocTTBarcodeStatus4(String docTTBarcodeStatus4) {
		this.docTTBarcodeStatus4 = docTTBarcodeStatus4;
	}
	public String getDocTTBarcodeStatus5() {
		return docTTBarcodeStatus5;
	}
	public void setDocTTBarcodeStatus5(String docTTBarcodeStatus5) {
		this.docTTBarcodeStatus5 = docTTBarcodeStatus5;
	}
	public String getDocTTJobID() {
		return docTTJobID;
	}
	public void setDocTTJobID(String docTTJobID) {
		this.docTTJobID = docTTJobID;
	}
	public String getDocVerificationRecipient() {
		return docVerificationRecipient;
	}
	public void setDocVerificationRecipient(String docVerificationRecipient) {
		this.docVerificationRecipient = docVerificationRecipient;
	}
	public String getJobHostUserID() {
		return jobHostUserID;
	}
	public void setJobHostUserID(String jobHostUserID) {
		this.jobHostUserID = jobHostUserID;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public static ArrayList<DocumentProperty> getDocumentPropertiesFromTabDelimittedFile(String filepath){
		ArrayList<DocumentProperty> results = new ArrayList<DocumentProperty>();
		BufferedReader reader = setupReader(filepath);
		String readLine;
		boolean firstLine = true;
		HashMap<String, Integer> fieldIdxs = null;
		try{
			while( (readLine = reader.readLine() ) != null ) {
				String[] fields = readLine.split("\\t",-1);
				if( firstLine ){
					fieldIdxs = getInputFileFieldIdxs(fields);
					firstLine=false;
				} else {
					DocumentProperty dp = new DocumentProperty();
					dp.setDocAVScanCount(fields[fieldIdxs.get("Doc.AV.ScanCount")]);
					dp.setDocAddress1(fields[fieldIdxs.get("Doc.Address.1")]);
					dp.setDocAddress2(fields[fieldIdxs.get("Doc.Address.2")]);
					dp.setDocAddress3(fields[fieldIdxs.get("Doc.Address.3")]);
					dp.setDocAddress4(fields[fieldIdxs.get("Doc.Address.4")]);
					dp.setDocAddress5(fields[fieldIdxs.get("Doc.Address.5")]);
					dp.setDocAddress6(fields[fieldIdxs.get("Doc.Address.6")]);
					dp.setDocAddress7(fields[fieldIdxs.get("Doc.Address.7")]);
					dp.setDocAddressCity(fields[fieldIdxs.get("Doc.Address.City")]);
					dp.setDocAddressCityStateZip(fields[fieldIdxs.get("Doc.Address.CityStateZip")]);
					dp.setDocAddressCompany(fields[fieldIdxs.get("Doc.Address.Company")]);
					dp.setDocAddressCountry(fields[fieldIdxs.get("Doc.Address.Country")]);
					dp.setDocAddressDeliveryPoint(fields[fieldIdxs.get("Doc.Address.DeliveryPoint")]);
					dp.setDocAddressFullName(fields[fieldIdxs.get("Doc.Address.FullName")]);
					dp.setDocAddressOther(fields[fieldIdxs.get("Doc.Address.Other")]);
					dp.setDocAddressPostalCode(fields[fieldIdxs.get("Doc.Address.PostalCode")]);
					dp.setDocAddressPrimary(fields[fieldIdxs.get("Doc.Address.Primary")]);
					dp.setDocAddressProvince(fields[fieldIdxs.get("Doc.Address.Province")]);
					dp.setDocAddressSecondary(fields[fieldIdxs.get("Doc.Address.Secondary")]);
					dp.setDocAddressState(fields[fieldIdxs.get("Doc.Address.State")]);
					dp.setDocAddressUrbanization(fields[fieldIdxs.get("Doc.Address.Urbanization")]);
					dp.setDocAddressZipCode(fields[fieldIdxs.get("Doc.Address.ZipCode")]);
					dp.setDocChildJobID(fields[fieldIdxs.get("Doc.ChildJobID")]);
					dp.setDocCombinedDocID(fields[fieldIdxs.get("Doc.CombinedDocID")]);
					dp.setDocCombinedDocument(fields[fieldIdxs.get("Doc.CombinedDocument")]);
					dp.setDocCombinedOriginalJobID(fields[fieldIdxs.get("Doc.CombinedOriginalJobID")]);
					dp.setDocCombinedSequence(fields[fieldIdxs.get("Doc.CombinedSequence")]);
					dp.setDocDVLAAccountNo(fields[fieldIdxs.get("Doc.DVLA.AccountNo")]);
					dp.setDocDVLAAddress1(fields[fieldIdxs.get("Doc.DVLA.Address1")]);
					dp.setDocDVLAAddress2(fields[fieldIdxs.get("Doc.DVLA.Address2")]);
					dp.setDocDVLAAddress3(fields[fieldIdxs.get("Doc.DVLA.Address3")]);
					dp.setDocDVLAAddress4(fields[fieldIdxs.get("Doc.DVLA.Address4")]);
					dp.setDocDVLAAddress5(fields[fieldIdxs.get("Doc.DVLA.Address5")]);
					dp.setDocDVLAAppName(fields[fieldIdxs.get("Doc.DVLA.AppName")]);
					dp.setDocDVLABatchType(fields[fieldIdxs.get("Doc.DVLA.BatchType")]);
					dp.setDocDVLAColour(fields[fieldIdxs.get("Doc.DVLA.Colour")]);
					dp.setDocDVLADPS(fields[fieldIdxs.get("Doc.DVLA.DPS")]);
					dp.setDocDVLADocType(fields[fieldIdxs.get("Doc.DVLA.DocType")]);
					dp.setDocDVLAEndOfGroup(fields[fieldIdxs.get("Doc.DVLA.EndOfGroup")]);
					dp.setDocDVLAEndOfTray(fields[fieldIdxs.get("Doc.DVLA.EndOfTray")]);
					dp.setDocDVLAEnvelope(fields[fieldIdxs.get("Doc.DVLA.Envelope")]);
					dp.setDocDVLAFleetNo(fields[fieldIdxs.get("Doc.DVLA.FleetNo")]);
					dp.setDocDVLAGroupId(fields[fieldIdxs.get("Doc.DVLA.GroupId")]);
					dp.setDocDVLAInsertPack(fields[fieldIdxs.get("Doc.DVLA.InsertPack")]);
					dp.setDocDVLALanguage(fields[fieldIdxs.get("Doc.DVLA.Language")]);
					dp.setDocDVLAMailerBarcode(fields[fieldIdxs.get("Doc.DVLA.MailerBarcode")]);
					dp.setDocDVLAMailerFunctions(fields[fieldIdxs.get("Doc.DVLA.MailerFunctions")]);
					dp.setDocDVLAMailingProduct(fields[fieldIdxs.get("Doc.DVLA.MailingProduct")]);
					dp.setDocDVLAMailmarkBarcode(fields[fieldIdxs.get("Doc.DVLA.MailmarkBarcode")]);
					dp.setDocDVLAMailsortCode(fields[fieldIdxs.get("Doc.DVLA.MailsortCode")]);
					dp.setDocDVLAName1(fields[fieldIdxs.get("Doc.DVLA.Name1")]);
					dp.setDocDVLAName2(fields[fieldIdxs.get("Doc.DVLA.Name2")]);
					dp.setDocDVLAOTT(fields[fieldIdxs.get("Doc.DVLA.OTT")]);
					dp.setDocDVLAOriginalRunDate(fields[fieldIdxs.get("Doc.DVLA.OriginalRunDate")]);
					dp.setDocDVLAOriginalRunNo(fields[fieldIdxs.get("Doc.DVLA.OriginalRunNo")]);
					dp.setDocDVLAPaperSize(fields[fieldIdxs.get("Doc.DVLA.PaperSize")]);
					dp.setDocDVLAPlex(fields[fieldIdxs.get("Doc.DVLA.Plex")]);
					dp.setDocDVLAPostCode(fields[fieldIdxs.get("Doc.DVLA.PostCode")]);
					dp.setDocDVLARef(fields[fieldIdxs.get("Doc.DVLA.Ref")]);
					dp.setDocDVLARef2(fields[fieldIdxs.get("Doc.DVLA.Ref2")]);
					dp.setDocDVLARunDate(fields[fieldIdxs.get("Doc.DVLA.RunDate")]);
					dp.setDocDVLARunNo(fields[fieldIdxs.get("Doc.DVLA.RunNo")]);
					dp.setDocDVLASelectorName(fields[fieldIdxs.get("Doc.DVLA.SelectorName")]);
					dp.setDocDVLASerialNo(fields[fieldIdxs.get("Doc.DVLA.SerialNo")]);
					dp.setDocDVLASite(fields[fieldIdxs.get("Doc.DVLA.Site")]);
					dp.setDocDVLASortField(fields[fieldIdxs.get("Doc.DVLA.SortField")]);
					dp.setDocDVLAStationery(fields[fieldIdxs.get("Doc.DVLA.Stationery")]);
					dp.setDocDVLAStreamingCode(fields[fieldIdxs.get("Doc.DVLA.StreamingCode")]);
					dp.setDocDVLASubBatchType(fields[fieldIdxs.get("Doc.DVLA.SubBatchType")]);
					dp.setDocDVLATitle(fields[fieldIdxs.get("Doc.DVLA.Title")]);
					dp.setDocDVLATotalPagesInGroup(fields[fieldIdxs.get("Doc.DVLA.TotalPagesInGroup")]);
					dp.setDocDataLen(fields[fieldIdxs.get("Doc.DataLen")]);
					dp.setDocDataOffset(fields[fieldIdxs.get("Doc.DataOffset")]);
					dp.setDocDocSizePieceThickness(fields[fieldIdxs.get("Doc.DocSize.PieceThickness")]);
					dp.setDocDocSizePieceWeight(fields[fieldIdxs.get("Doc.DocSize.PieceWeight")]);
					dp.setDocDueOut(fields[fieldIdxs.get("Doc.DueOut")]);
					dp.setDocEmailAddress(fields[fieldIdxs.get("Doc.EmailAddress")]);
					dp.setDocEmailSent(fields[fieldIdxs.get("Doc.Email.Sent")]);
					dp.setDocID(fields[fieldIdxs.get("Doc.ID")]);
					dp.setDocInsertBinResults(fields[fieldIdxs.get("Doc.Insert.BinResults")]);
					dp.setDocInsertBinTriggers(fields[fieldIdxs.get("Doc.Insert.BinTriggers")]);
					dp.setDocInsertDisposition(fields[fieldIdxs.get("Doc.Insert.Disposition")]);
					dp.setDocInsertDivertBin(fields[fieldIdxs.get("Doc.Insert.DivertBin")]);
					dp.setDocInsertInserterID(fields[fieldIdxs.get("Doc.Insert.InserterID")]);
					dp.setDocInsertIteration(fields[fieldIdxs.get("Doc.Insert.Iteration")]);
					dp.setDocInsertOperatorID(fields[fieldIdxs.get("Doc.Insert.OperatorID")]);
					dp.setDocInsertOriginalBarCode(fields[fieldIdxs.get("Doc.Insert.OriginalBarCode")]);
					dp.setDocInsertPendingDisposition(fields[fieldIdxs.get("Doc.Insert.PendingDisposition")]);
					dp.setDocInsertRecipientName(fields[fieldIdxs.get("Doc.Insert.RecipientName")]);
					dp.setDocInsertSequence(fields[fieldIdxs.get("Doc.Insert.Sequence")]);
					dp.setDocInsertStatus(fields[fieldIdxs.get("Doc.Insert.Status")]);
					dp.setDocInsertTimeStamp(fields[fieldIdxs.get("Doc.Insert.TimeStamp")]);
					dp.setDocInserterStatusCode(fields[fieldIdxs.get("Doc.Inserter.StatusCode")]);
					dp.setDocInserterStatusCodeExtended(fields[fieldIdxs.get("Doc.Inserter.StatusCodeExtended")]);
					dp.setDocMadeAvailableByJobId(fields[fieldIdxs.get("Doc.MadeAvailableByJobId")]);
					dp.setDocMemberNumber(fields[fieldIdxs.get("Doc.Member.Number")]);
					dp.setDocOriginalFirstPage(fields[fieldIdxs.get("Doc.OriginalFirstPage")]);
					dp.setDocOriginalJobID(fields[fieldIdxs.get("Doc.OriginalJobID")]);
					dp.setDocOriginalPages(fields[fieldIdxs.get("Doc.OriginalPages")]);
					dp.setDocOriginalSequence(fields[fieldIdxs.get("Doc.OriginalSequence")]);
					dp.setDocOriginalSheets(fields[fieldIdxs.get("Doc.OriginalSheets")]);
					dp.setDocPDZSOriginalInputFile(fields[fieldIdxs.get("Doc.PDZS.OriginalInputFile")]);
					dp.setDocPersistentID(fields[fieldIdxs.get("Doc.Persistent.ID")]);					
					dp.setDocPostalAddressProcessingRC(fields[fieldIdxs.get("Doc.Postal.AddressProcessingRC")]);
					dp.setDocPostalCategory(fields[fieldIdxs.get("Doc.Postal.Category")]);
					dp.setDocPostalChangeAddressRC(fields[fieldIdxs.get("Doc.Postal.ChangeAddressRC")]);
					dp.setDocPostalContainerBreakMark(fields[fieldIdxs.get("Doc.Postal.ContainerBreakMark")]);
					dp.setDocPostalContainerNumber(fields[fieldIdxs.get("Doc.Postal.ContainerNumber")]);
					dp.setDocPostalHandlingUnitBreakMark(fields[fieldIdxs.get("Doc.Postal.HandlingUnitBreakMark")]);
					dp.setDocPostalHandlingUnitNumber(fields[fieldIdxs.get("Doc.Postal.HandlingUnitNumber")]);
					dp.setDocPostalPackageBreakMark(fields[fieldIdxs.get("Doc.Postal.PackageBreakMark")]);
					dp.setDocPostalPackageNumber(fields[fieldIdxs.get("Doc.Postal.PackageNumber")]);
					dp.setDocPostalPostageRate(fields[fieldIdxs.get("Doc.Postal.PostageRate")]);
					dp.setDocPostalPostageRateCode(fields[fieldIdxs.get("Doc.Postal.PostageRateCode")]);
					dp.setDocPostalSequenceNumber(fields[fieldIdxs.get("Doc.Postal.SequenceNumber")]);
					dp.setDocPostalSequencingProcessingRC(fields[fieldIdxs.get("Doc.Postal.SequencingProcessingRC")]);
					dp.setDocPull(fields[fieldIdxs.get("Doc.Pull")]);
					dp.setDocPullProp(fields[fieldIdxs.get("Doc.PullProp")]);
					dp.setDocSaveAll(fields[fieldIdxs.get("Doc.SaveAll")]);
					dp.setDocSequenceInChild(fields[fieldIdxs.get("Doc.SequenceInChild")]);
					dp.setDocSourceFileName(fields[fieldIdxs.get("Doc.SourceFileName")]);
					dp.setDocTTBarcodeScanTime1(fields[fieldIdxs.get("Doc.TT.BarcodeScanTime1")]);
					dp.setDocTTBarcodeScanTime2(fields[fieldIdxs.get("Doc.TT.BarcodeScanTime2")]);
					dp.setDocTTBarcodeScanTime3(fields[fieldIdxs.get("Doc.TT.BarcodeScanTime3")]);
					dp.setDocTTBarcodeScanTime4(fields[fieldIdxs.get("Doc.TT.BarcodeScanTime4")]);
					dp.setDocTTBarcodeScanTime5(fields[fieldIdxs.get("Doc.TT.BarcodeScanTime5")]);
					dp.setDocTTBarcodeStatus1(fields[fieldIdxs.get("Doc.TT.BarcodeStatus1")]);
					dp.setDocTTBarcodeStatus2(fields[fieldIdxs.get("Doc.TT.BarcodeStatus2")]);
					dp.setDocTTBarcodeStatus3(fields[fieldIdxs.get("Doc.TT.BarcodeStatus3")]);
					dp.setDocTTBarcodeStatus4(fields[fieldIdxs.get("Doc.TT.BarcodeStatus4")]);
					dp.setDocTTBarcodeStatus5(fields[fieldIdxs.get("Doc.TT.BarcodeStatus5")]);
					dp.setDocTTJobID(fields[fieldIdxs.get("Doc.TT.JobID")]);
					dp.setDocVerificationRecipient(fields[fieldIdxs.get("Doc.Verification.Recipient")]);
					dp.setJobHostUserID(fields[fieldIdxs.get("Job.Host.UserID")]);
					dp.setJobName(fields[fieldIdxs.get("Job.Name")]);
					results.add(dp);
				}
			}
			
		} catch (NullPointerException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeReader(reader);
		}
		return results;
	}
	
	public static String getHeaderRecordAsString(String inputFilePath){
		BufferedReader reader = setupReader(inputFilePath);
		String result = "";
		try {
			result = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeReader(reader);
		}
		return result;
	}
	
	private static BufferedReader setupReader(String input) {
        try {
        	File inputFile = new File(input);
			BufferedReader b = new BufferedReader(new FileReader(inputFile));
			return b;
		} catch (FileNotFoundException e) {
			System.exit(1);
		}
		return null;
	}
	
	private static HashMap<String, Integer> getInputFileFieldIdxs(String[] fields) {
		HashMap<String, Integer> results = new HashMap<String, Integer>();
		for(int i = 0 ; i < fields.length ; i ++){
			results.put(fields[i], i);
		}
		return results;
	}
	
	private static void closeReader(BufferedReader reader){
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString(){
		final String SEPARATOR = "\t";
		StringBuilder sb = new StringBuilder();
		sb.append(docAVScanCount + SEPARATOR);
		sb.append(docAddress1 + SEPARATOR);
		sb.append(docAddress2 + SEPARATOR);
		sb.append(docAddress3 + SEPARATOR);
		sb.append(docAddress4 + SEPARATOR);
		sb.append(docAddress5 + SEPARATOR);
		sb.append(docAddress6 + SEPARATOR);
		sb.append(docAddress7 + SEPARATOR);
		sb.append(docAddressCity + SEPARATOR);
		sb.append(docAddressCityStateZip + SEPARATOR);
		sb.append(docAddressCompany + SEPARATOR);
		sb.append(docAddressCountry + SEPARATOR);
		sb.append(docAddressDeliveryPoint + SEPARATOR);
		sb.append(docAddressFullName + SEPARATOR);
		sb.append(docAddressOther + SEPARATOR);
		sb.append(docAddressPostalCode + SEPARATOR);
		sb.append(docAddressPrimary + SEPARATOR);
		sb.append(docAddressProvince + SEPARATOR);
		sb.append(docAddressSecondary + SEPARATOR);
		sb.append(docAddressState + SEPARATOR);
		sb.append(docAddressUrbanization + SEPARATOR);
		sb.append(docAddressZipCode + SEPARATOR);
		sb.append(docChildJobID + SEPARATOR);
		sb.append(docCombinedDocID + SEPARATOR);
		sb.append(docCombinedDocument + SEPARATOR);
		sb.append(docCombinedOriginalJobID + SEPARATOR);
		sb.append(docCombinedSequence + SEPARATOR);
		sb.append(docDVLAAccountNo + SEPARATOR);
		sb.append(docDVLAAddress1 + SEPARATOR);
		sb.append(docDVLAAddress2 + SEPARATOR);
		sb.append(docDVLAAddress3 + SEPARATOR);
		sb.append(docDVLAAddress4 + SEPARATOR);
		sb.append(docDVLAAddress5 + SEPARATOR);
		sb.append(docDVLAAppName + SEPARATOR);
		sb.append(docDVLABatchType + SEPARATOR);
		sb.append(docDVLAColour + SEPARATOR);
		sb.append(docDVLADPS + SEPARATOR);
		sb.append(docDVLADocType + SEPARATOR);
		sb.append(docDVLAEndOfGroup + SEPARATOR);
		sb.append(docDVLAEndOfTray + SEPARATOR);
		sb.append(docDVLAEnvelope + SEPARATOR);
		sb.append(docDVLAFleetNo + SEPARATOR);
		sb.append(docDVLAGroupId + SEPARATOR);
		sb.append(docDVLAInsertPack + SEPARATOR);
		sb.append(docDVLALanguage + SEPARATOR);
		sb.append(docDVLAMailerBarcode + SEPARATOR);
		sb.append(docDVLAMailerFunctions + SEPARATOR);
		sb.append(docDVLAMailingProduct + SEPARATOR);
		sb.append(docDVLAMailmarkBarcode + SEPARATOR);
		sb.append(docDVLAMailsortCode + SEPARATOR);
		sb.append(docDVLAName1 + SEPARATOR);
		sb.append(docDVLAName2 + SEPARATOR);
		sb.append(docDVLAOTT + SEPARATOR);
		sb.append(docDVLAOriginalRunDate + SEPARATOR);
		sb.append(docDVLAOriginalRunNo + SEPARATOR);
		sb.append(docDVLAPaperSize + SEPARATOR);
		sb.append(docDVLAPlex + SEPARATOR);
		sb.append(docDVLAPostCode + SEPARATOR);
		sb.append(docDVLARef + SEPARATOR);
		sb.append(docDVLARef2 + SEPARATOR);
		sb.append(docDVLARunDate + SEPARATOR);
		sb.append(docDVLARunNo + SEPARATOR);
		sb.append(docDVLASelectorName + SEPARATOR);
		sb.append(docDVLASerialNo + SEPARATOR);
		sb.append(docDVLASite + SEPARATOR);
		sb.append(docDVLASortField + SEPARATOR);
		sb.append(docDVLAStationery + SEPARATOR);
		sb.append(docDVLAStreamingCode + SEPARATOR);
		sb.append(docDVLASubBatchType + SEPARATOR);
		sb.append(docDVLATitle + SEPARATOR);
		sb.append(docDVLATotalPagesInGroup + SEPARATOR);
		sb.append(docDataLen + SEPARATOR);
		sb.append(docDataOffset + SEPARATOR);
		sb.append(docDocSizePieceThickness + SEPARATOR);
		sb.append(docDocSizePieceWeight + SEPARATOR);
		sb.append(docDueOut + SEPARATOR);
		sb.append(docEmailAddress + SEPARATOR);
		sb.append(docEmailSent + SEPARATOR);
		sb.append(docID + SEPARATOR);
		sb.append(docInsertBinResults + SEPARATOR);
		sb.append(docInsertBinTriggers + SEPARATOR);
		sb.append(docInsertDisposition + SEPARATOR);
		sb.append(docInsertDivertBin + SEPARATOR);
		sb.append(docInsertInserterID + SEPARATOR);
		sb.append(docInsertIteration + SEPARATOR);
		sb.append(docInsertOperatorID + SEPARATOR);
		sb.append(docInsertOriginalBarCode + SEPARATOR);
		sb.append(docInsertPendingDisposition + SEPARATOR);
		sb.append(docInsertRecipientName + SEPARATOR);
		sb.append(docInsertSequence + SEPARATOR);
		sb.append(docInsertStatus + SEPARATOR);
		sb.append(docInsertTimeStamp + SEPARATOR);
		sb.append(docInserterStatusCode + SEPARATOR);
		sb.append(docInserterStatusCodeExtended + SEPARATOR);
		sb.append(docMadeAvailableByJobId + SEPARATOR);
		sb.append(docMemberNumber + SEPARATOR);
		sb.append(docOriginalFirstPage + SEPARATOR);
		sb.append(docOriginalJobID + SEPARATOR);
		sb.append(docOriginalPages + SEPARATOR);
		sb.append(docOriginalSequence + SEPARATOR);
		sb.append(docOriginalSheets + SEPARATOR);
		sb.append(docPDZSOriginalInputFile + SEPARATOR);
		sb.append(docPersistentID + SEPARATOR);
		sb.append(docPostalAddressProcessingRC + SEPARATOR);
		sb.append(docPostalCategory + SEPARATOR);
		sb.append(docPostalChangeAddressRC + SEPARATOR);
		sb.append(docPostalContainerBreakMark + SEPARATOR);
		sb.append(docPostalContainerNumber + SEPARATOR);
		sb.append(docPostalHandlingUnitBreakMark + SEPARATOR);
		sb.append(docPostalHandlingUnitNumber + SEPARATOR);
		sb.append(docPostalPackageBreakMark + SEPARATOR);
		sb.append(docPostalPackageNumber + SEPARATOR);
		sb.append(docPostalPostageRate + SEPARATOR);
		sb.append(docPostalPostageRateCode + SEPARATOR);
		sb.append(docPostalSequenceNumber + SEPARATOR);
		sb.append(docPostalSequencingProcessingRC + SEPARATOR);
		sb.append(docPull + SEPARATOR);
		sb.append(docPullProp + SEPARATOR);
		sb.append(docSaveAll + SEPARATOR);
		sb.append(docSequenceInChild + SEPARATOR);
		sb.append(docSourceFileName + SEPARATOR);
		sb.append(docTTBarcodeScanTime1 + SEPARATOR);
		sb.append(docTTBarcodeScanTime2 + SEPARATOR);
		sb.append(docTTBarcodeScanTime3 + SEPARATOR);
		sb.append(docTTBarcodeScanTime4 + SEPARATOR);
		sb.append(docTTBarcodeScanTime5 + SEPARATOR);
		sb.append(docTTBarcodeStatus1 + SEPARATOR);
		sb.append(docTTBarcodeStatus2 + SEPARATOR);
		sb.append(docTTBarcodeStatus3 + SEPARATOR);
		sb.append(docTTBarcodeStatus4 + SEPARATOR);
		sb.append(docTTBarcodeStatus5 + SEPARATOR);
		sb.append(docTTJobID + SEPARATOR);
		sb.append(docVerificationRecipient + SEPARATOR);
		sb.append(jobHostUserID + SEPARATOR);
		sb.append(jobName);
		return sb.toString();
	}
}
