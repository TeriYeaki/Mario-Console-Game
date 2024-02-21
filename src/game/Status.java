package game;

/**
 * Use this enum class to give `buff` or `debuff`.
 * It is also useful to give a `state` to abilities or actions that can be attached-detached.
 */
public enum Status {
    HOSTILE_TO_ENEMY, // use this status to be considered hostile towards enemy (e.g., to be attacked by enemy)
    TALL, // use this status to tell that current instance has "grown".
    CAN_JUMP, // use this status to tell that current instance can jump.
    CAN_COLLECT_COINS, // use this status to tell that current instance can collect coins.
    SUPER_MUSHROOM_EFFECT, ANGERED_BY_ATTACK, // use this status to tell that current instance has a super mushroom.
}
