package array;

/**
 * 11. 盛最多水的容器
 */
public class MaxArea {

  /**
   * 暴力解法 双重循环
   * @param height
   * @return
   */
//  public static int maxArea(int[] height) {
//    int area=0;
//    int min;
//    for(int i=0;i<height.length;i++){
//      for(int j=1;j<height.length;j++){
//        min=Math.min(height[i],height[j]);
//        if(Math.abs(i-j)*min>area){
//          area=Math.abs(i-j)*min;
//        }
//      }
//    }
//    return area;
//  }

  /**
   * 双指针解法 一个从头开始，一个从尾部开始
   * 如果较短的垂直线向内移动一格，容器宽度减1，但是高度可能会增大，容量可能会增大
   * 如果较长的垂直线向内移动一格，容器宽度减1，但是高度只可能不变或者减小，容量会减小
   * 所以每次只需要将矮的指针向内移动一格即可
   * @param height
   * @return
   */
  public static int maxArea(int[] height) {
    int area=0;
    int i=0,j=height.length-1;
    int high;
    while(i<j){
      high=Math.min(height[i],height[j]);
      area=area>(high*(j-i))?area:high*(j-i);
      if(height[i]<height[j]){
        i++;
      }else{
        j--;
      }
    }
    return area;
  }

  public static void main(String[] args) {
    int[] nums={1,8,6,2,5,4,8,3,7};
    System.out.println(maxArea(nums));
  }

}

