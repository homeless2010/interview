package practice.exam;

/**
 * 仓库管理系统
 */

import io.swagger.models.auth.In;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 示例 1：
 * <p>
 * 输入：
 * ["StorageSystem","store","retrieve","query"]
 * [[2,2,1,1,2],[0,1,0,2],[3,1],[3]]
 * <p>
 * 输出：[null,4,2,[1,0,0]]
 * <p>
 * 解释：
 * StorageSystem obj = StorageSystem(2,2,1,1,2); // 初始化仓库，2 个冷藏室（每天价格 2）和 1 个常温室（每天价格 1），货物最多可以延期 2 天；
 * obj.store(0,1,0,2); // 在日期 0，存单 1 预定冷藏室 2 天；由于存在空闲冷藏室，返回支付款项 2*2 = 4
 * obj.retrieve(3,1); // 在日期 3 提取存单 1 对应物品。实际延迟天数为 1 = 3 - (0 + 2)，返回补交费用 2*1 = 2 ；因过期但未超出 2 天，不会被清空，
 * obj.query(3); // 当前物品已成功取出、物品未取仍在仓库中、物品被清空的存单各有 1 份、0 份、0 份，返回 [1,0,0]
 * 注：输出中的 null 表示此对应函数无输出（其中：C 的构造函数有返回值，但是也是无需输出）
 */
public class StorageSystem {
    //仓库有冷藏和常温两种类型的储藏室，初始化其对应的数量和每天租赁价格；
    //若客户租赁过期且超出 delay 天后，依旧未提取货物，该储物区将被清空
    private int coldStorageNum;
    private int coldStoragePrice;
    private int normalStorageNum;
    private int normalStoragePrice;
    private int delay;
    //存储单子
    private Map<Integer, List<Receipt>> coldStorageList = new HashMap<>();
    private Map<Integer, List<Receipt>> normalStorageList = new HashMap<>();
    //操作单数
    private Map<Integer, Integer> receiptOPnum = new HashMap<>();

    public StorageSystem(int coldStorageNum, int coldStoragePrice, int normalStorageNum, int normalStoragePrice, int delay) {
        this.coldStorageNum = coldStorageNum;
        this.coldStoragePrice = coldStoragePrice;
        this.normalStorageNum = normalStorageNum;
        this.normalStoragePrice = normalStoragePrice;
        this.delay = delay;
    }

    //在日期 date 为存单 storageId 租赁 storageType 类型的一个储藏室，并存放物品 storageDays 天。
    int store(int date, int storageId, int storageType, int storageDays) {
        return storageType * storageDays;
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
    int retrieve(int date, int storageId) {
        expired(date);

    }

    /**
     * o    若存单未过期时，则取出物品，并返回 0；
     * <p>
     * o    若存单过期但未超出 delay 天，则取出物品，并返回需要补交的费用（实际延迟天数 * 每日价格），实际延迟天数 = date - (「租赁起始日期」+ storageDays)；
     * <p>
     * o    若存单过期且已超出 delay 天（日期超过 「租赁起始日期」+ storageDays + delay ）时，则物品已被清空、取出失败，并返回 -1。
     * <p>
     * ·         query(int date) — 请返回截止日期 date 时 3 种状态的存单数量序列，依次为：物品已成功取出、物品未取仍在仓库中、物品被清空的存单数量。
     * <p>
     * 注意：保证函数 store、retrieve、query 的日期 date 参数按输入顺序非严格递增；
     */
    int[] query(int date) {
        expired(date);
        int[] ret = new int[3];
        ret[0] = receiptOPnum.get(1);
        ret[1] = receiptOPnum.get(2);
        ret[2] = receiptOPnum.get(3);
        return ret;
    }

    void expired(int date) {
//        List<Receipt> coldReceipts = coldStorageList.get(date);
////        List<Integer> coldExpired = coldReceipts.stream().filter(r -> date > r.getDate() + r.getStorageDays() + delay)
////                .mapToInt(r -> r.getStorageId()).boxed().collect(Collectors.toList());
//        List<Receipt> coldExpired = coldReceipts.stream().filter(r -> date > r.getDate() + r.getStorageDays() + delay)
//                .collect(Collectors.toList());
//        receiptOPnum.put(3, receiptOPnum.get(3) == null ? coldExpired.size() : receiptOPnum.get(3) + coldExpired.size());
//        coldReceipts.removeAll(coldExpired);
//        receiptOPnum.put(2, receiptOPnum.get(2) == null ? coldReceipts.size() : receiptOPnum.get(2) + coldReceipts.size());
//        List<Receipt> normalReceipts = normalStorageList.get(date);
//        List<Receipt> normalExpired = normalReceipts.stream().filter(r -> date > r.getDate() + r.getStorageDays() + delay)
//                .collect(Collectors.toList());
//        receiptOPnum.put(3, receiptOPnum.get(3) == null ? normalReceipts.size() : receiptOPnum.get(3) + normalReceipts.size());
//        normalReceipts.removeAll(normalExpired);
//        receiptOPnum.put(2, receiptOPnum.get(2) == null ? normalReceipts.size() : receiptOPnum.get(2) + normalReceipts.size());
    }

}


class Receipt {
    private int date;
    private int storageId;
    private int storageType;
    private int storageDays;

    public Receipt() {

    }

    public Receipt(int date, int storageId, int storageType, int storageDays) {
        this.date = date;
        this.storageId = storageId;
        this.storageType = storageType;
        this.storageDays = storageDays;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getStorageId() {
        return storageId;
    }

    public void setStorageId(int storageId) {
        this.storageId = storageId;
    }

    public int getStorageType() {
        return storageType;
    }

    public void setStorageType(int storageType) {
        this.storageType = storageType;
    }

    public int getStorageDays() {
        return storageDays;
    }

    public void setStorageDays(int storageDays) {
        this.storageDays = storageDays;
    }
}
