import 'package:flutter/material.dart';
import 'package:l_with_springboot/model/Product.dart';
import 'package:l_with_springboot/viewmodel/ProductProvider.dart';
import 'package:provider/provider.dart';

class ProductModifyPage extends StatelessWidget {

  ProductModifyPage({super.key});

  final _formKey = GlobalKey<FormState>();
  final _nameController = TextEditingController();
  final _priceController = TextEditingController();
  final _descriptionController = TextEditingController();

  @override
  Widget build(BuildContext context) {

    // 전달된 arguments (수정하기 이전의 Product)
    final product = ModalRoute.of(context)!.settings.arguments as Product;

    // 수정하기 이전의 Product 정보를 TextFormField 에 표시하기
    _nameController.text = product.name;
    _priceController.text = product.price.toString();
    _descriptionController.text = product.description;

    return Scaffold(
      appBar: AppBar(title: const Text("Product Modify")),
      body: Center(
        child: Padding(
          padding: EdgeInsets.symmetric(vertical: 6.0, horizontal: 32.0),
          child: Form(
            key: _formKey,
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              mainAxisSize: MainAxisSize.min,
              children: [
                TextFormField(
                  decoration: InputDecoration(hintText: "상품명"),
                  validator: (String? value) => value!.isEmpty ? "상품명 입력" : null,
                  controller: _nameController,
                ),
                TextFormField(
                  decoration: InputDecoration(hintText: "상품가격"),
                  validator: (String? value) => int.parse(value!) <= 0 ? "상품가격 오류" : null,
                  controller: _priceController,
                ),
                TextFormField(
                  decoration: InputDecoration(hintText: "상품개요"),
                  validator: (String? value) => value!.isEmpty ? "상품개요 입력" : null,
                  controller: _descriptionController,
                ),
                SizedBox(height: 50),
                Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    ElevatedButton(
                      onPressed: () {
                        Navigator.of(context).pop();  // 뒤로 가기
                      },
                      child: const Text("취소")
                    ),
                    ElevatedButton(
                      onPressed: () {
                        if(_formKey.currentState!.validate()) {  // Form 내부의 모든 TextFormField 의 validator 콜백 결과를 모두 통과하면
                          context.read<ProductProvider>().modifyProduct(
                            Product(
                              id: product.id,
                              name: _nameController.text,
                              price: int.parse(_priceController.text),
                              description: _descriptionController.text,
                            )
                          );
                          Navigator.of(context).pop();  // 뒤로 가기
                        }
                      },
                      child: const Text("수정")
                    ),
                  ],
                )
              ],
            ),
          ),
        ),
      ),
    );

  }

}