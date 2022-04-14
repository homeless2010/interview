package practice.exam;

/**
 * 仓库管理系统
 */
public class StorageSystem {
    //仓库有冷藏和常温两种类型的储藏室，初始化其对应的数量和每天租赁价格；
    //若客户租赁过期且超出 delay 天后，依旧未提取货物，该储物区将被清空
    public StorageSystem(int coldStorageNum, int coldStoragePrice, int normalStorageNum, int normalStoragePrice, int delay) {

    }

    //在日期 date 为存单 storageId 租赁 storageType 类型的一个储藏室，并存放物品 storageDays 天。
    void store(int date, int storageId, int storageType, int storageDays) {

    }

    /**
     * 若有空间则存储成功，则需预付 storageDays 天的费用（按照实际使用储藏室类型进行计算：天数 * 每日租赁价格），返回该费用；
     * <p>
     * §  当常温储藏室空间不足时，可使用空闲的冷藏储藏室存储；反之不可以；
     * <p>
     * §  date 为「租赁起始日期」，日期超过 date + storageDays 时开始过期
     * <p>
     * o    若无空间则不做任何处理，并返回 -1。
     * <p>
     * 系统保证 storageId 参数全局唯一。storageType 为 0 表示冷藏， 1 表示常温
     */
//在日期 date ，客户取出存单 storageId （存单一定存在且未被提取）对应的物品：
    void retrieve(int date, int storageId) {

    }
    /**
     * o    若存单未过期时，则取出物品，并返回 0；
     *
     * o    若存单过期但未超出 delay 天，则取出物品，并返回需要补交的费用（实际延迟天数 * 每日价格），实际延迟天数 = date - (「租赁起始日期」+ storageDays)；
     *
     * o    若存单过期且已超出 delay 天（日期超过 「租赁起始日期」+ storageDays + delay ）时，则物品已被清空、取出失败，并返回 -1。
     *
     * ·         query(int date) — 请返回截止日期 date 时 3 种状态的存单数量序列，依次为：物品已成功取出、物品未取仍在仓库中、物品被清空的存单数量。
     *
     * 注意：保证函数 store、retrieve、query 的日期 date 参数按输入顺序非严格递增；
     */
}
