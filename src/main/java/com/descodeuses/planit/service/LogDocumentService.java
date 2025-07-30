package com.descodeuses.planit.service;
import com.descodeuses.planit.model.LogDocument;
import com.descodeuses.planit.repository.LogDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogDocumentService {

    @Autowired
    private LogDocumentRepository repo;
    public void addLog (String Text){
        LogDocument doc = new LogDocument();
        doc.setText(Text);

        doc.addExtra("ip", "192.168.1.1");
        doc.addExtra("browser", "Chrome");
        doc.addExtra("userAgent", "Mozilla/5.0");
        
        repo.save(doc);

    }

}
