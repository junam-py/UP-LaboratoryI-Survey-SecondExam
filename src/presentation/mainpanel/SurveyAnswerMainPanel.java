package presentation.mainpanel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;

import presentation.PanelManager;
import services.QuestionService;
import services.AnswerService;
import services.exception.ServiceException;
import services.model.Question;

public class SurveyAnswerMainPanel extends JPanel {
    private final PanelManager panelManager;
    private final QuestionService questionService;
    private final AnswerService answerService;
    private final List<Question> questions;
    private final List<ButtonGroup> groups = new ArrayList<>();

    public SurveyAnswerMainPanel(PanelManager panelManager, Long surveyId) throws ServiceException {
        this.panelManager    = panelManager;
        this.questionService = new QuestionService();
        this.answerService   = new AnswerService();
        setLayout(new BorderLayout());

        // Carga de preguntas de la encuesta
        questions = questionService.findBySurveyId(surveyId);

        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        for (Question q : questions) {
            JPanel p = new JPanel();
            p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
            p.add(new JLabel(q.getText()));

            ButtonGroup bg = new ButtonGroup();
            JPanel opts = new JPanel();
            opts.setLayout(new BoxLayout(opts, BoxLayout.X_AXIS));
            for (int i = 1; i <= 5; i++) {
                JRadioButton rb = new JRadioButton(String.valueOf(i));
                bg.add(rb);
                opts.add(rb);
                if (i == 3) rb.setSelected(true);
            }
            p.add(opts);

            center.add(p);
            groups.add(bg);
        }

        add(new JScrollPane(center), BorderLayout.CENTER);

        JButton submit = new JButton("Submit");
        submit.addActionListener(this::onSubmit);
        JButton back = new JButton("Back");
        back.addActionListener(e -> panelManager.showSurveyList());

        JPanel south = new JPanel();
        south.add(submit);
        south.add(back);
        add(south, BorderLayout.SOUTH);
    }

    private void onSubmit(ActionEvent e) {
        try {
            for (int i = 0; i < questions.size(); i++) {
                Question q = questions.get(i);
                ButtonGroup bg = groups.get(i);

                String sel = null;
                Enumeration<AbstractButton> buttons = bg.getElements();
                while (buttons.hasMoreElements()) {
                    AbstractButton b = buttons.nextElement();
                    if (b.isSelected()) {
                        sel = b.getText();
                        break;
                    }
                }
                int rating = Integer.parseInt(sel);

                answerService.answerQuestion(
                    q.getId(),
                    getCurrentUserId(),
                    rating,
                    new Date()
                );
            }
            JOptionPane.showMessageDialog(this, "Thank you for your responses!");
            panelManager.showSurveyList();
        } catch (ServiceException ex) {
            JOptionPane.showMessageDialog(this, "Error submitting answers:\n" + ex.getMessage());
        }
    }

    /** TODO: implementar obtención real del ID de usuario */
    private Long getCurrentUserId() {
        return 1L;
    }
}
