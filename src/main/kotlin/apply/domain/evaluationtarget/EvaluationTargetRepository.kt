package apply.domain.evaluationtarget

import org.springframework.data.jpa.repository.JpaRepository

interface EvaluationTargetRepository : JpaRepository<EvaluationTarget, Long> {
    fun findByEvaluationIdAndUserId(evaluationId: Long, userId: Long): EvaluationTarget?

    fun findAllByEvaluationId(evaluationId: Long): List<EvaluationTarget>

    fun existsByEvaluationId(evaluationId: Long): Boolean

    fun deleteByUserIdIn(userIds: Collection<Long>)

    fun deleteByEvaluationIdAndUserIdIn(evaluationId: Long, userIds: Collection<Long>)

    fun findAllByEvaluationIdAndUserIdIn(evaluationId: Long, userIds: Set<Long>): List<EvaluationTarget>

    fun findAllByEvaluationIdAndEvaluationStatus(
        evaluationId: Long,
        evaluationStatus: EvaluationStatus
    ): List<EvaluationTarget>

    fun existsByUserIdAndEvaluationId(userId: Long, evaluationId: Long): Boolean
}
