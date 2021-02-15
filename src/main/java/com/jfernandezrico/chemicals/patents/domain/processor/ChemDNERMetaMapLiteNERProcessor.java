package com.jfernandezrico.chemicals.patents.domain.processor;

/*import bioc.BioCDocument;
import com.jfernandezrico.chemicals.patents.domain.value.NERClassification;
import com.jfernandezrico.chemicals.patents.domain.value.NERConceptInfo;
import gov.nih.nlm.nls.metamap.document.ChemDNER;
import gov.nih.nlm.nls.metamap.lite.types.Entity;
import gov.nih.nlm.nls.ner.MetaMapLite;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor public class ChemDNERMetaMapLiteNERProcessor implements NERProcessor {

    private final MetaMapLite metaMapLite;


    @Override
    public List<NERClassification> classifyContent(String patentId, String title, String text)
        throws Exception {
        List<NERClassification> classifications = new ArrayList();
        if (patentId != null && title != null && text != null) {
            BioCDocument document =
                ChemDNER.instantiateBioCDocument(patentId + "\t" + title + "\t" + text);
            List<BioCDocument> documentList = new ArrayList();
            documentList.add(document);
            List<Entity> entityList = metaMapLite.processDocumentList(documentList);
            classifications = entityList.stream().map(
                entity -> NERClassification.builder().matchedText(entity.getMatchedText())
                    .conceptInfoList(entity.getEvList().stream().map(
                        ev -> NERConceptInfo.builder().sourceSet(ev.getConceptInfo().getSourceSet())
                            .cui(ev.getConceptInfo().getCUI())
                            .semanticTypeSet(ev.getConceptInfo().getSemanticTypeSet()).build())
                        .collect(Collectors.toList())).build()).collect(Collectors.toList());
        }
        return classifications;
    }


}*/
