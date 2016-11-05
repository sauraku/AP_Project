import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by skwow on 10/23/2016.
 */
public class myQuery1Panel
{
    protected JPanel panel2=new JPanel(new GridBagLayout());
    private GridBagConstraints panel2gbc= new GridBagConstraints();
    private JLabel sinceYear,from,to;
    protected JButton resetButton,searchButton;
    protected JTextField sinceYearTeaxtField,fromTextField,toTextField,nameTitleTextField;
    protected JComboBox yearCombo,searchByCombo;
    protected Checkbox chkSortByYear,chkSortByRelevance;
    protected CheckboxGroup sort;

    public myQuery1Panel()
    {
        panel2gbc.insets= new Insets(10,10,10,10);
        prepareSearchByComboBox();
        prepareYearSearchComboBox();
        prepareCheckBoxUI();
        prepareButtons();
        colorize();
    }

    private void colorize()
    {
        panel2.setOpaque(false);
        sinceYear.setForeground(Color.cyan);
        from.setForeground(Color.cyan);
        to.setForeground(Color.cyan);
        resetButton.setBackground(Color.cyan);
        searchButton.setBackground(Color.cyan);
    }

    public void prepareButtons()
    {
        resetButton=new JButton("Reset");
        resetButton.setBackground(Color.gray);
        resetButton.setFont(new Font("Serif", Font.BOLD, 30));
        resetButton.setPreferredSize(new Dimension(200,50));
        searchButton=new JButton("Search");
        searchButton.setBackground(Color.gray);
        searchButton.setFont(new Font("Serif", Font.BOLD, 30));
        searchButton.setPreferredSize(new Dimension(200,50));
        panel2gbc.gridx=0;
        panel2gbc.gridy=8;
        panel2.add(searchButton,panel2gbc);
        panel2gbc.gridx=1;
        panel2gbc.gridy=8;
        panel2.add(resetButton,panel2gbc);
    }

    private void prepareCheckBoxUI()
    {
        panel2gbc.gridy=4;
        panel2gbc.gridx=0;
        panel2.add(new JLabel("         "),panel2gbc);
        panel2gbc.gridy=5;
        panel2.add(new JLabel("         "),panel2gbc);
        sort = new CheckboxGroup();
        chkSortByYear = new Checkbox("Sort By Year",sort,false);
        chkSortByYear.setForeground(Color.cyan);
        chkSortByYear.setBackground(Color.gray);
        chkSortByYear.setFont(new Font("Serif", Font.BOLD, 30));
        chkSortByYear.setPreferredSize(new Dimension(300,50));
        chkSortByRelevance = new Checkbox("Sort By Relevence",sort,false);
        chkSortByRelevance.setForeground(Color.cyan);
        chkSortByRelevance.setBackground(Color.gray);
        chkSortByRelevance.setFont(new Font("Serif", Font.BOLD, 30));
        chkSortByRelevance.setPreferredSize(new Dimension(300,50));
        panel2gbc.gridwidth=2;
        panel2gbc.gridx=0;
        panel2gbc.gridy=6;
        panel2.add(chkSortByYear,panel2gbc);
        panel2gbc.gridx=0;
        panel2gbc.gridy=7;
        panel2.add(chkSortByRelevance,panel2gbc);
        panel2gbc.gridwidth=1;
    }

    private void prepareYearSearchComboBox()
    {
        final DefaultComboBoxModel yearSelect = new DefaultComboBoxModel();
        yearSelect.addElement("Year Select");
        yearSelect.addElement("Since Year");
        yearSelect.addElement("Custom Range");
        yearCombo = new JComboBox(yearSelect);
        yearCombo.setSelectedIndex(0);
        yearCombo.setPreferredSize(new Dimension(100,50));
        yearCombo.setFont(new Font("Serif", Font.BOLD, 30));
        yearCombo.setBackground(Color.cyan);
        panel2gbc.fill= GridBagConstraints.HORIZONTAL;
        panel2gbc.gridx=0;
        panel2gbc.gridy=2;
        panel2.add(yearCombo,panel2gbc);
        YearSearchUI();
        yearCombo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Object temp = yearCombo.getSelectedIndex();
                if(temp.equals(1))
                {
                    sinceYear.setVisible(true);
                    sinceYearTeaxtField.setVisible(true);
                    from.setVisible(false);
                    fromTextField.setVisible(false);
                    to.setVisible(false);
                    toTextField.setVisible(false);
                }
                else if(temp.equals(0))
                {
                    sinceYear.setVisible(false);
                    sinceYearTeaxtField.setVisible(false);
                    from.setVisible(false);
                    fromTextField.setVisible(false);
                    to.setVisible(false);
                    toTextField.setVisible(false);
                }
                else if(temp.equals(2))
                {
                    sinceYear.setVisible(false);
                    sinceYearTeaxtField.setVisible(false);
                    from.setVisible(true);
                    fromTextField.setVisible(true);
                    to.setVisible(true);
                    toTextField.setVisible(true);
                }
            }
        });
    }
    private void YearSearchUI()
    {
        sinceYear= new JLabel("From");
        sinceYearTeaxtField=new JTextField("");
        sinceYearTeaxtField.setPreferredSize(new Dimension(200,50));
        sinceYear.setPreferredSize(new Dimension(100,50));
        sinceYear.setFont(new Font("Serif", Font.BOLD, 30));
        sinceYearTeaxtField.setFont(new Font("Serif", Font.BOLD, 30));
        sinceYear.setForeground(Color.cyan);
        panel2gbc.gridx=0;
        panel2gbc.gridy=3;
        panel2.add(sinceYear,panel2gbc);
        panel2gbc.gridx=1;
        panel2gbc.gridy=3;
        panel2.add(sinceYearTeaxtField,panel2gbc);
        sinceYear.setVisible(false);
        sinceYearTeaxtField.setVisible(false);

        from= new JLabel("From");
        fromTextField=new JTextField("");
        fromTextField.setPreferredSize(new Dimension(200,50));
        from.setPreferredSize(new Dimension(100,50));
        from.setForeground(Color.gray);
        from.setFont(new Font("Serif", Font.BOLD, 30));
        fromTextField.setFont(new Font("Serif", Font.BOLD, 30));
        panel2gbc.gridx=0;
        panel2gbc.gridy=3;
        panel2.add(from,panel2gbc);
        panel2gbc.gridx=1;
        //panel2gbc.gridy=3;
        panel2.add(fromTextField,panel2gbc);
        from.setVisible(false);
        fromTextField.setVisible(false);
        to= new JLabel("To");
        toTextField=new JTextField("");
        toTextField.setPreferredSize(new Dimension(200,50));
        to.setPreferredSize(new Dimension(100,50));
        to.setForeground(Color.cyan);
        to.setFont(new Font("Serif", Font.BOLD, 30));
        toTextField.setFont(new Font("Serif", Font.BOLD, 30));
        panel2gbc.gridx=2;
        //panel2gbc.gridy=3;
        panel2.add(to,panel2gbc);
        panel2gbc.gridx=3;
        //panel2gbc.gridy=3;
        panel2.add(toTextField,panel2gbc);
        to.setVisible(false);
        toTextField.setVisible(false);
    }

    private void prepareSearchByComboBox()
    {
        final DefaultComboBoxModel searchBy = new DefaultComboBoxModel();
        searchBy.addElement("Search By");
        searchBy.addElement("Name");
        searchBy.addElement("Title");
        searchByCombo = new JComboBox(searchBy);
        searchByCombo.setSelectedIndex(0);
        searchByCombo.setPreferredSize(new Dimension(100,50));
        searchByCombo.setFont(new Font("Serif", Font.BOLD, 30));
        searchByCombo.setBackground(Color.cyan);
        panel2gbc.gridx=0;
        panel2gbc.gridy=0;
        panel2gbc.fill= GridBagConstraints.HORIZONTAL;
        panel2.add(searchByCombo,panel2gbc);
        JLabel nameTitleLabel= new JLabel("Name/TiTle");
        nameTitleTextField=new JTextField("");
        nameTitleTextField.setPreferredSize(new Dimension(200,50));
        nameTitleLabel.setPreferredSize(new Dimension(200,50));
        nameTitleLabel.setFont(new Font("Serif", Font.BOLD, 30));
        nameTitleTextField.setFont(new Font("Serif", Font.BOLD, 30));
        nameTitleLabel.setForeground(Color.cyan);
        // panel2gbc.gridx=0;
        panel2gbc.gridy=1;
        panel2.add(nameTitleLabel,panel2gbc);
        panel2gbc.gridx=1;
        // panel2gbc.gridy=1;
        panel2.add(nameTitleTextField,panel2gbc);
    }



}
