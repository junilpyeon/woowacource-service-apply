package apply.application

import apply.domain.recruitment.Recruitment
import apply.domain.recruitment.RecruitmentRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import support.createLocalDateTime
import javax.annotation.PostConstruct

@Transactional
@Service
class RecruitmentService(val recruitmentRepository: RecruitmentRepository) {
    fun findAll(): List<Recruitment> {
        return recruitmentRepository.findAll()
    }

    @PostConstruct
    private fun populateDummy() {
        if (recruitmentRepository.count() != 0L) {
            return
        }
        val recruitments = listOf(
            Recruitment(
                "웹 백엔드 2기",
                false,
                createLocalDateTime(2019, 10, 25, 10),
                createLocalDateTime(2019, 11, 5, 10)
            ),
            Recruitment(
                "웹 백엔드 3기",
                true,
                createLocalDateTime(2020, 10, 25, 15),
                createLocalDateTime(2020, 11, 5, 10)
            ),
            Recruitment(
                "웹 프론트엔드 3기",
                false,
                createLocalDateTime(2020, 10, 25, 15),
                createLocalDateTime(2020, 11, 5, 10)
            )
        )
        recruitmentRepository.saveAll(recruitments)
    }
}