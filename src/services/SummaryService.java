package services;

import services.exception.ServiceException;
import services.model.Answer;
import database.DAO.AnswerDAO;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SummaryService {
    private final AnswerDAO answerDAO;

    public SummaryService(AnswerDAO answerDAO) {
        this.answerDAO = answerDAO;
    }

    /**
     * For each question in the given survey, returns a map:
     *    questionId → (ratingValue → count)
     * filtered by the date range [from, to].
     */
    public Map<Long, Map<Integer, Integer>> getSummary(Long surveyId, Date from, Date to)
            throws ServiceException {
        try {
            List<Answer> answers = answerDAO.findBySurveyAndDateRange(surveyId, from, to);
            Map<Long, Map<Integer, Integer>> summary = new HashMap<>();
            for (Answer ans : answers) {
                Long qId = ans.getQuestionId();
                summary
                  .computeIfAbsent(qId, k -> new HashMap<>())
                  .merge(ans.getRating(), 1, Integer::sum);
            }
            return summary;
        } catch (Exception e) {
            throw new ServiceException("Error generating answer summary", e);
        }
    }
}
