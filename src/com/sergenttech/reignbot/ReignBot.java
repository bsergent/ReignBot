package com.sergenttech.reignbot;

import java.io.IOException;
import static java.lang.Thread.sleep;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.htmlcleaner.CleanerProperties;
import org.htmlcleaner.DomSerializer;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.htmlcleaner.XPatherException;

/**
 *
 * @author bsergent
 */
public class ReignBot extends javax.swing.JFrame {
    
    private final String VERSION = "1.0.3B";
    private final int COOLDOWN = 60*5; // 5 minutes in seconds
    private String phpSessId;
    private String comLink;
    private String nationId;
    private String userId;
    private CookieStore cookieStore = new BasicCookieStore();
    private DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    
    /*
    TODO
    - Add resources to cache periodically
    - Send spies to enemies to compile reports
    - Replant farms
    - Login to create credientials
    - Automatically upgrade farms on each unlock
    */

    public ReignBot() {
        initComponents();
        this.setTitle("ReignBot v"+VERSION);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginDialog = new javax.swing.JDialog();
        loginButton = new javax.swing.JButton();
        userField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        rememberCheck = new javax.swing.JCheckBox();
        accessField = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        logTextArea = new javax.swing.JTextArea();
        accountButton = new javax.swing.JButton();
        moneyLabel = new javax.swing.JLabel();
        oreLabel = new javax.swing.JLabel();
        oilLabel = new javax.swing.JLabel();
        uraniumLabel = new javax.swing.JLabel();
        statusLabel = new javax.swing.JLabel();
        depositButton = new javax.swing.JButton();
        replantDropdown = new javax.swing.JComboBox<>();
        uraniumProgress = new javax.swing.JProgressBar();
        farm1Progress = new javax.swing.JProgressBar();
        farm2Progress = new javax.swing.JProgressBar();
        uraniumProgressLabel = new javax.swing.JLabel();
        farm1Label = new javax.swing.JLabel();
        farm2Label = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cooldownProgress = new javax.swing.JProgressBar();

        loginDialog.setTitle("ReignBot - Login");
        loginDialog.setMinimumSize(new java.awt.Dimension(320, 180));
        loginDialog.setPreferredSize(new java.awt.Dimension(320, 180));
        loginDialog.setSize(new java.awt.Dimension(298, 167));
        loginDialog.setType(java.awt.Window.Type.POPUP);

        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        jLabel4.setLabelFor(userField);
        jLabel4.setText("Reign Username");

        jLabel5.setLabelFor(passwordField);
        jLabel5.setText("Reign Password");

        jLabel6.setLabelFor(accessField);
        jLabel6.setText("Access Code");

        rememberCheck.setText("Remember Me");

        javax.swing.GroupLayout loginDialogLayout = new javax.swing.GroupLayout(loginDialog.getContentPane());
        loginDialog.getContentPane().setLayout(loginDialogLayout);
        loginDialogLayout.setHorizontalGroup(
            loginDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(loginDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userField)
                    .addComponent(passwordField)
                    .addGroup(loginDialogLayout.createSequentialGroup()
                        .addGroup(loginDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginDialogLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(accessField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(rememberCheck)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loginButton)))
                .addContainerGap())
        );
        loginDialogLayout.setVerticalGroup(
            loginDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(loginDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginButton)
                    .addComponent(rememberCheck)
                    .addComponent(jLabel6)
                    .addComponent(accessField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ReignBot");

        logTextArea.setEditable(false);
        logTextArea.setColumns(20);
        logTextArea.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        logTextArea.setRows(5);
        jScrollPane1.setViewportView(logTextArea);

        accountButton.setText("Login");
        accountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountButtonActionPerformed(evt);
            }
        });

        moneyLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sergenttech/reignbot/resources/icon.money.png"))); // NOI18N
        moneyLabel.setToolTipText("Money");

        oreLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sergenttech/reignbot/resources/icon.metal.png"))); // NOI18N
        oreLabel.setToolTipText("Metal");

        oilLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sergenttech/reignbot/resources/icon.oil.png"))); // NOI18N
        oilLabel.setToolTipText("Oil");

        uraniumLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sergenttech/reignbot/resources/icon.uranium.png"))); // NOI18N
        uraniumLabel.setToolTipText("Uranium");

        statusLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        statusLabel.setText("Uninitialized");

        depositButton.setText("Auto Deposits");
        depositButton.setToolTipText("Automatic deposits to alliance cache");
        depositButton.setEnabled(false);

        replantDropdown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Replant...", "Cabbage ($8/hr)", "Rice ($8/hr)", "Cotton ($8/hr)", "Tomato (8.5/hr)", "Peanuts ($11/hr)", "Peas ($9.5/hr)", "Wheat ($10/hr)", "Avocado ($9/hr)", "Strawberry ($12/hr)", "Coffee ($17/hr)", "Potato ($15/hr)", "Pepper ($13/hr)", "Pumpkin ($15/hr)", "Tobacco ($18/hr)", "Grapes ($18.5/hr)", "Corn ($14/hr)", "Blackberry ($19/hr)", "Sugar ($17/hr)", "Cannabis ($20/hr)", "Cocoa ($20/hr)" }));
        replantDropdown.setToolTipText("Crop to replant with");

        farm1Progress.setToolTipText("Farm 1 progress");

        farm2Progress.setToolTipText("Farm 2 progress");

        uraniumProgressLabel.setText("Uranium");

        farm1Label.setText("Farm: Unknown");

        farm2Label.setText("Farm: Unknown");

        jLabel1.setText("Cooldown");

        cooldownProgress.setToolTipText("Query cooldown");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(moneyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(oreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(oilLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(uraniumLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(depositButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(replantDropdown, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(uraniumProgressLabel)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(46, 46, 46)
                            .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(uraniumProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(farm1Label)
                        .addComponent(farm1Progress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(farm2Label)
                        .addComponent(farm2Progress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(accountButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addComponent(cooldownProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(moneyLabel)
                                .addComponent(oreLabel)
                                .addComponent(oilLabel)
                                .addComponent(uraniumLabel))
                            .addComponent(statusLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(uraniumProgressLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(uraniumProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(farm1Label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(farm1Progress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(farm2Label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(farm2Progress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cooldownProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 76, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(depositButton)
                    .addComponent(accountButton)
                    .addComponent(replantDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void accountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountButtonActionPerformed
        loginDialog.setVisible(true);
    }//GEN-LAST:event_accountButtonActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        /*phpSessId = sessField.getText();
        comLink = comField.getText();
        nationId = nationField.getText();
        userId = userField.getText();*/
        log("Initialized.");
        phpSessId = "86d1b7b23bcb71ffda277473429cee4a";
        comLink = "174e701af6310ebf6660764269a95780";
        nationId = "17719";
        userId = "58828";
        
        // Update cookies
        BasicClientCookie cookie = new BasicClientCookie("PHPSESSID", phpSessId);
        cookie.setDomain("reign.ws");
        cookie.setPath("/");
        cookieStore.addCookie(cookie);
        
        cookie = new BasicClientCookie("comlink", comLink);
        cookie.setDomain(".reign.ws");
        cookie.setPath("/");
        cookieStore.addCookie(cookie);
        
        cookie = new BasicClientCookie("nationid", nationId);
        cookie.setDomain(".reign.ws");
        cookie.setPath("/");
        cookieStore.addCookie(cookie);
        
        cookie = new BasicClientCookie("userid", userId);
        cookie.setDomain(".reign.ws");
        cookie.setPath("/");
        cookieStore.addCookie(cookie);
        
        
        Thread th = new Thread() {
            public void run() {
                try {
                    while (true) {
                        statusLabel.setText("Querying");
                        harvest();
                        updateResources();
                        statusLabel.setText(" ");
                        for (int i = 0; i < COOLDOWN; i++) {
                            cooldownProgress.setValue((int)((COOLDOWN-i)*1.0f/COOLDOWN*100));
                            sleep(1000);
                        }
                    }
                } catch (IOException ex) {
                    Logger.getLogger(ReignBot.class.getName()).log(Level.SEVERE, null, ex);
                } catch (XPatherException ex) {
                    Logger.getLogger(ReignBot.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ReignBot.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParserConfigurationException ex) {
                    Logger.getLogger(ReignBot.class.getName()).log(Level.SEVERE, null, ex);
                } catch (XPathExpressionException ex) {
                    Logger.getLogger(ReignBot.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        th.start();
    }//GEN-LAST:event_loginButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                //if ("Nimbus".equals(info.getName())) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ReignBot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReignBot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReignBot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReignBot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReignBot().setVisible(true);
            }
        });
    }
    
    private void log(String line) {
        Date date = new Date();
        logTextArea.setText(logTextArea.getText()+"["+timeFormat.format(date)+"] "+line+"\n");
    }
    
    private void harvest() throws IOException, XPatherException, ParserConfigurationException, XPathExpressionException {
        String uraniumCode = "";
        String farm1Code = "";
        String farm2Code = "";
        HttpEntity entity = queryGame();
        HtmlCleaner cleaner = new HtmlCleaner();
        
        CleanerProperties props = cleaner.getProperties();
        TagNode root = cleaner.clean(EntityUtils.toString(entity));
        org.w3c.dom.Document doc = new DomSerializer(new CleanerProperties()).createDOM(root);
        XPath xpath = XPathFactory.newInstance().newXPath();
        
        // Uranium
        Object[] foundList = root.evaluateXPath("//a/img[@src='/images/icon.uranium.png']");
        if (foundList.length > 0) {
            uraniumCode = ((TagNode)foundList[0]).getParent().getAttributeByName("href");
        }
        
        // Farms
        //log(xpath.evaluate("//a[contains(@href,'harvest')]", XPathConstants.NODE));
        foundList = root.evaluateXPath("//div[@style='margin:1 0 1 1;']/div/a");
        if (foundList.length > 0) {
            farm1Code = ((TagNode)foundList[0]).getAttributeByName("href");
            if (!(farm1Code.contains("harvest") || farm1Code.contains("inspect"))) farm1Code = "";
        }
        if (foundList.length > 1) {
            farm2Code = ((TagNode)foundList[1]).getAttributeByName("href");
            if (!(farm2Code.contains("harvest") || farm2Code.contains("inspect"))) farm2Code = "";
        }
        
        EntityUtils.consume(entity);
        if (!uraniumCode.equals("")) {
            queryGame(uraniumCode);
            log("Harvested uranium.");
        }
        if (!farm1Code.equals("")) {
            if (farm1Code.contains("harvest")) {
                queryGame(farm1Code);
                farm1Progress.setValue(0);
                farm1Label.setText("Farm: Harvested");
                log("Harvested farm.");
            } else if (farm1Code.contains("inspect") && !((TagNode)foundList[0]).hasAttribute("title")) {
                if (replantDropdown.getSelectedIndex() != 0) {
                    List<NameValuePair> data = new ArrayList<>();
                    data.add(new BasicNameValuePair("plant_structure", farm1Code.substring(9)));
                    data.add(new BasicNameValuePair("plant", ""+replantDropdown.getSelectedIndex()));
                    queryGamePost(data);
                    farm1Progress.setValue(0);
                    farm1Label.setText("Farm: Replanted");
                    log("Replanted "+replantDropdown.getItemAt(replantDropdown.getSelectedIndex())+".");
                }
            } else {
                // Update progress bar
                String width = ((TagNode)foundList[0]).getParent().getChildTags()[1].getAttributeByName("style");
                String w = ((TagNode)foundList[0]).getParent().getChildTags()[1].getChildTags()[0].getAttributeByName("style");
                width = width.substring(width.indexOf("width: ")+7);
                width = width.substring(0, width.indexOf("px"));
                w = w.substring(w.indexOf("width: ")+7);
                w = w.substring(0, w.indexOf("px"));
                int progress = Math.min((int) (Integer.parseInt(w)*1.0f/Integer.parseInt(width)*100)+4, 100);
                farm1Progress.setValue(progress);
                farm1Label.setText("Farm: "+((TagNode)foundList[0]).getAttributeByName("title").replace("remaining ", ""));
            }
        }
        if (!farm2Code.equals("")) {
            if (farm2Code.contains("harvest")) {
                queryGame(farm2Code);
                farm2Progress.setValue(0);
                farm2Label.setText("Farm: Harvested");
                log("Harvested farm.");
            } else if (farm2Code.contains("inspect") && !((TagNode)foundList[1]).hasAttribute("title")) {
                if (replantDropdown.getSelectedIndex() != 0) {
                    List<NameValuePair> data = new ArrayList<>();
                    data.add(new BasicNameValuePair("plant_structure", farm2Code.substring(9)));
                    data.add(new BasicNameValuePair("plant", ""+replantDropdown.getSelectedIndex()));
                    queryGamePost(data);
                    farm2Progress.setValue(0);
                    farm2Label.setText("Farm: Replanted");
                    log("Replanted "+replantDropdown.getItemAt(replantDropdown.getSelectedIndex())+".");
                }
            } else {
                // Update progress bar
                String width = ((TagNode)foundList[1]).getParent().getChildTags()[1].getAttributeByName("style");
                String w = ((TagNode)foundList[1]).getParent().getChildTags()[1].getChildTags()[0].getAttributeByName("style");
                width = width.substring(width.indexOf("width: ")+7);
                width = width.substring(0, width.indexOf("px"));
                w = w.substring(w.indexOf("width: ")+7);
                w = w.substring(0, w.indexOf("px"));
                int progress = Math.min((int) (Integer.parseInt(w)*1.0f/Integer.parseInt(width)*100)+4, 100);
                farm2Progress.setValue(progress);
                farm2Label.setText("Farm: "+((TagNode)foundList[1]).getAttributeByName("title").replace("remaining ", ""));
            }
        }
    }
    
    private void updateResources() throws IOException, XPatherException {
        HttpEntity entity = queryGame();

        HtmlCleaner cleaner = new HtmlCleaner();
        CleanerProperties props = cleaner.getProperties();
        TagNode root = cleaner.clean(EntityUtils.toString(entity));
        Object[] foundList = root.evaluateXPath("//div[@class='slot_value']");
        moneyLabel.setText(((TagNode)foundList[0]).getText().toString());
        oreLabel.setText(((TagNode)foundList[1]).getText().toString());
        oilLabel.setText(((TagNode)foundList[2]).getText().toString());
        uraniumLabel.setText(((TagNode)foundList[3]).getText().toString());

        EntityUtils.consume(entity);
    }
    
    private HttpEntity queryGame() throws IOException {
        return queryGame("");
    }
    
    private HttpEntity queryGame(String command) throws IOException {
        HttpGet get = new HttpGet("http://reign.ws/"+command);
        DefaultHttpClient client = new DefaultHttpClient();
        client.setCookieStore(cookieStore);
        return client.execute(get).getEntity();
    }
    
    private HttpEntity queryGamePost(List<NameValuePair> data) throws IOException {
        HttpPost post = new HttpPost("http://reign.ws/?");
        DefaultHttpClient client = new DefaultHttpClient();
        client.setCookieStore(cookieStore);
        post.setEntity(new UrlEncodedFormEntity(data));
        return client.execute(post).getEntity();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField accessField;
    private javax.swing.JButton accountButton;
    private javax.swing.JProgressBar cooldownProgress;
    private javax.swing.JButton depositButton;
    private javax.swing.JLabel farm1Label;
    private javax.swing.JProgressBar farm1Progress;
    private javax.swing.JLabel farm2Label;
    private javax.swing.JProgressBar farm2Progress;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextArea logTextArea;
    private javax.swing.JButton loginButton;
    private javax.swing.JDialog loginDialog;
    private javax.swing.JLabel moneyLabel;
    private javax.swing.JLabel oilLabel;
    private javax.swing.JLabel oreLabel;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JCheckBox rememberCheck;
    private javax.swing.JComboBox<String> replantDropdown;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JLabel uraniumLabel;
    private javax.swing.JProgressBar uraniumProgress;
    private javax.swing.JLabel uraniumProgressLabel;
    private javax.swing.JTextField userField;
    // End of variables declaration//GEN-END:variables
}
